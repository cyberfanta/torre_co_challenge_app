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
import com.cyberfanta.torre_co_challenge_app.controllers.*
import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*


internal class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private var currentTypeSearch: Int = 0 //0 = Opportunities , 1 = Peoples , 2 = Job , 3 = Bio

    private val nameSearch: String = ""

    private lateinit var modelManager_Opportunities: ModelManager

    private lateinit var adapter_Opportunities: CardAdapter_Opportunities
    private lateinit var adapter_Peoples: CardAdapter_Peoples
    private var cardList_Opportunities: ArrayList<CardItem_Opportunities> = ArrayList<CardItem_Opportunities>(
        0
    )
    private var cardList_Peoples: ArrayList<CardItem_Peoples> = ArrayList<CardItem_Peoples>(0)

    private var QueryThread = Thread(readModelFromConnection())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        initializingRecyclersView()
        initializingConnectionController()
        fillRecyclerView()
    }

    //Initialize the recyclerView
    private fun initializingRecyclersView() {
        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.setHasFixedSize(true)
        val layoutManager_Opportunities: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter_Opportunities = CardAdapter_Opportunities(cardList_Opportunities)
        //todo: keep scroll when update
//        adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        recycler.layoutManager = layoutManager_Opportunities
        recycler.adapter = adapter_Opportunities

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    fillRecyclerView()
                    Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_LONG).show()
                }
            }
        })

        adapter_Opportunities.setOnItemClickListener(object :
            CardAdapter_Opportunities.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Clicked item " + position + " TODO",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })


        recycler = findViewById(R.id.recycler_bios)
        recycler.setHasFixedSize(true)
        val layoutManager_Peoples: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter_Peoples = CardAdapter_Peoples(cardList_Peoples)
        //todo: keep scroll when update
//        adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        recycler.layoutManager = layoutManager_Peoples
        recycler.adapter = adapter_Peoples

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    fillRecyclerView()
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
    private fun fillRecyclerView() {
        if (!QueryThread.isAlive) {
            QueryThread = Thread(readModelFromConnection())
            QueryThread.start()
        }
    }

    //Initial load for recicler view when button pressed
    @Suppress("UNUSED_PARAMETER")
    fun requestCards(view: View) {
        fillRecyclerView()
    }

    //Changing Jobs to Bios
    @Suppress("UNUSED_PARAMETER")
    fun bioToJobs(view: View) {
        currentTypeSearch = 0

        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.visibility = View.VISIBLE
        recycler= findViewById(R.id.recycler_bios)
        recycler.visibility = View.GONE

        fillRecyclerView()
    }

    //Changing Bios to Jobs
    @Suppress("UNUSED_PARAMETER")
    fun jobsToBios(view: View) {
        currentTypeSearch = 1

        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.visibility = View.GONE
        recycler= findViewById(R.id.recycler_bios)
        recycler.visibility = View.VISIBLE

        fillRecyclerView()
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
                    loadPeopleCards()
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
        val size: Int = cardList_Opportunities.size
        for (i in 0..19)
            cardList_Opportunities.add(CardItem_Opportunities(modelManager_Opportunities.nextOpportunities()))

        adapter_Opportunities.notifyItemRangeInserted(size, 20)
    }

    fun loadPeopleCards() {
        val size: Int = cardList_Peoples.size
        for (i in 0..19)
            cardList_Peoples.add(CardItem_Peoples(modelManager_Opportunities.nextPeoples()))

        adapter_Peoples.notifyItemRangeInserted(size, 20)
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