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

    private lateinit var modelManager_Opportunities: ModelManager

    private lateinit var adapter_Opportunities: RecyclerView.Adapter<CardViewHolder>
    private lateinit var adapter_Peoples: RecyclerView.Adapter<CardViewHolder> //todo
    private var cardList_Opportunities: ArrayList<CardItem> = ArrayList<CardItem>(0)
    private var cardList_Peoples: ArrayList<CardItem> = ArrayList<CardItem>(0) //todo:

    private var QueryThread = Thread(readModelFromConnection())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializingRecyclersView()
        initializingConnectionController()
        requestFirstJobs()
    }

    //Initialize the recyclerView
    private fun initializingRecyclersView() {
        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter_Opportunities = CardAdapter(cardList_Opportunities)
        //todo: keep scroll when update
//        adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter_Opportunities

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    if (!QueryThread.isAlive) {
                        QueryThread = Thread(readModelFromConnection())
                        QueryThread.start()
                    }
                    Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_LONG).show()
                }
            }
        })



        recycler = findViewById(R.id.recycler_bios)
        recycler.setHasFixedSize(true)
        adapter_Peoples = CardAdapter(cardList_Peoples)
        //todo: keep scroll when update
//        adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter_Peoples

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    if (!QueryThread.isAlive) {
                        QueryThread = Thread(readModelFromConnection())
                        QueryThread.start()
                    }
                    Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    //    //Initialize the recyclerView
    private fun initializingConnectionController() {
        modelManager_Opportunities = ModelManager()
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
                    modelManager_Opportunities.loadOpportunities(20, cardList_Opportunities.size)
                } else if (currentTypeSearch == 1){
                    modelManager_Opportunities.loadPeoples(20, cardList_Peoples.size)
                } else if (currentTypeSearch == 2){
                    modelManager_Opportunities.loadJob(nameSearch)
                } else {
                    modelManager_Opportunities.loadBio(nameSearch)
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
            cardList_Opportunities.add(CardItem(modelManager_Opportunities.nextOpportunities()))

        adapter_Opportunities.notifyDataSetChanged()
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