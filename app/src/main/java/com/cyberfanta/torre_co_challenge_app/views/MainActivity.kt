package com.cyberfanta.torre_co_challenge_app.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter.CardViewHolder
import com.cyberfanta.torre_co_challenge_app.controllers.CardItem
import com.cyberfanta.torre_co_challenge_app.controllers.ModelManager
import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException
import java.util.*


internal class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val currentTypeSearch: Int = 0 //0 = Opportunities , 1 = Peoples , 2 = Job , 3 = Bio
    private val nameSearch: String = ""

    private lateinit var modelManager: ModelManager
    private lateinit var adapter: RecyclerView.Adapter<CardViewHolder>

    private var cardListOpportunities: ArrayList<CardItem> = ArrayList<CardItem>(0)

    private var QueryThread = Thread(readModelFromConnection())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializingRecyclerView()
        initializingConnectionController()
        requestFirstJobs()
    }

    //Initialize the recyclerView
    private fun initializingRecyclerView() {
        val recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter = CardAdapter(cardListOpportunities)
        //todo: keep scroll when update
//        adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(this@MainActivity, "Last", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    //    //Initialize the recyclerView
    private fun initializingConnectionController() {
        modelManager = ModelManager()
    }

    //Initial load for recicler view
    private fun requestFirstJobs() {
        if (!QueryThread.isAlive) {
            QueryThread = Thread(readModelFromConnection())
            QueryThread.start()
        }
    }

    //Initial load for recicler view when button pressed
    @Suppress("UNUSED_PARAMETER")
    fun requestCards(view: View) {
        if (!QueryThread.isAlive) {
            QueryThread = Thread(readModelFromConnection())
            QueryThread.start()
        }
    }

    //Load data from ModelFromConnection Class
    private inner class readModelFromConnection : Runnable {
        override fun run() {
            val message = handler.obtainMessage()

            try {
                if (currentTypeSearch == 0){
                    modelManager.loadOpportunities(20)
                } else if (currentTypeSearch == 1){
                    modelManager.loadPeoples(20)
                } else if (currentTypeSearch == 2){
                    modelManager.loadJob(nameSearch)
                } else {
                    modelManager.loadBio(nameSearch)
                }
            } catch (e: ConnectionException) {
                message.obj = "Error"
            }
            handler.sendMessageAtFrontOfQueue(message)
        }
    }

    //Handle the actions when ready to update the ui
    @Suppress("DEPRECATION")
    @SuppressLint("HandlerLeak")
    private val handler: Handler = object : Handler() {
        override fun handleMessage(message: Message) {
//            if (message.obj.equals("")) {
                if (currentTypeSearch == 0){
                    loadOpportunityCards()
                } else if (currentTypeSearch == 1){
                    //todo
                    loadOpportunityCards()
                } else if (currentTypeSearch == 2){
                    //todo
                    loadOpportunityCards()
                } else {
                    //todo
                    loadOpportunityCards()
                }
        }
    }

    fun loadOpportunityCards() {
        for (i in 0..19)
            cardListOpportunities.add(CardItem(modelManager.nextOpportunities()))

        adapter.notifyDataSetChanged()
    }


    //    ---






    //    ---
    /**
     * Create the setting menu of the application
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    /**
     * Handle the setting menu of the application
     */
    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_about) {
            val constraintLayout = findViewById<ConstraintLayout>(R.id.author)
            constraintLayout.visibility = View.VISIBLE
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //    ---
    /**
     * Show the developer info
     */
    @Suppress("UNUSED_PARAMETER")
    fun author_selected(view: View?) {
        val constraintLayout = findViewById<ConstraintLayout>(R.id.author)
        constraintLayout.visibility = View.GONE
    }


}