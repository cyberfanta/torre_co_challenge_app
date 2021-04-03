package com.cyberfanta.torre_co_challenge_app.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.*
import com.cyberfanta.torre_co_challenge_app.enumerator.ThreadReadType
import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*

internal class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private var currentTypeSearch: Int = 0 //0 = Opportunities , 1 = Peoples , 2 = Job , 3 = Bio

    private val nameSearch: String = ""

    private lateinit var modelManager: ModelManager

    private lateinit var adapter_Opportunities: CardAdapter_Opportunities
    private lateinit var adapter_Peoples: CardAdapter_Peoples

    private var cardList_Opportunities: ArrayList<CardItem_Opportunities>
    = ArrayList<CardItem_Opportunities>(20)
    private var cardList_Peoples: ArrayList<CardItem_Peoples>
    = ArrayList<CardItem_Peoples>(20)

    private var queriesThread = Thread(ReadModelFromConnection())

    private var bitmapInfo = Stack<Array<String>>()

    //    ---

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        initializingRecyclersView()
        initializingConnectionController()
        loadLoadingAnimation()
    }

    override fun onStart() {
        super.onStart()

        fillBothRecyclersView()
    }

    //    ---

    //Initialize the recyclerView
    private fun initializingRecyclersView() {
        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.setHasFixedSize(true)
        val layoutManager_Opportunities: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter_Opportunities = CardAdapter_Opportunities(cardList_Opportunities)
        recycler.layoutManager = layoutManager_Opportunities
        recycler.adapter = adapter_Opportunities

//        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (!recyclerView.canScrollVertically(1)) {
//                    val imageView = findViewById<ImageView>(R.id.loading)
//                    imageView.visibility = View.VISIBLE
//
//                    fillCurrentRecyclerView()
//                    Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })

        adapter_Opportunities.setOnItemClickListener(object :
            CardAdapter_Opportunities.OnItemClickListener {
            override fun onItemClick(position: Int) {
            }
        })

        adapter_Opportunities.setOnBottomReachedListener(object :
            CardAdapter_Opportunities.OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                val imageView = findViewById<ImageView>(R.id.loading)
                imageView.visibility = View.VISIBLE

                fillCurrentRecyclerView()
            }
        })

        //        ---

        recycler = findViewById(R.id.recycler_bios)
        recycler.setHasFixedSize(true)
        val layoutManager_Peoples: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter_Peoples = CardAdapter_Peoples(cardList_Peoples)
        recycler.layoutManager = layoutManager_Peoples
        recycler.adapter = adapter_Peoples

        adapter_Peoples.setOnItemClickListener(object :
            CardAdapter_Peoples.OnItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "Clicked item $position",
//                    Toast.LENGTH_SHORT
//                ).show()
            }
        })

        adapter_Peoples.setOnBottomReachedListener(object :
            CardAdapter_Peoples.OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                val imageView = findViewById<ImageView>(R.id.loading)
                imageView.visibility = View.VISIBLE

                fillCurrentRecyclerView()
            }
        })
    }

    //Initialize the Connection Controller
    private fun initializingConnectionController() {
        modelManager = ModelManager()
    }

    //Initialize loading animation
    private fun loadLoadingAnimation() {
        val imageView = findViewById<ImageView>(R.id.loading)

        val loading_animator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f)
        val loading_animatorSet = AnimatorSet()
        loading_animatorSet.play(loading_animator)
        loading_animatorSet.setDuration(1000)
        loading_animatorSet.addListener(
            object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    loading_animatorSet.start()
                }
            }
        )
        loading_animatorSet.start()
    }

    //    ---

    //Initial load for both recyclers view
    private fun fillBothRecyclersView() {
        if (!queriesThread.isAlive) {
            queriesThread = Thread(ReadBothModelFromConnection())
            queriesThread.start()
        }
    }

    //load current recycler view
    private fun fillCurrentRecyclerView() {
        if (!queriesThread.isAlive) {
            queriesThread = Thread(ReadModelFromConnection())
            queriesThread.start()
        }
    }

    //    ---

    //Open Search Tools
    @Suppress("UNUSED_PARAMETER")
    fun openSearchTools(view: View) {
        val constraintLayout: ConstraintLayout = findViewById(R.id.Search_Menu)
        constraintLayout.visibility = View.VISIBLE
        var imageView: ImageView = findViewById(R.id.Loupe_Background)
        imageView.visibility = View.GONE
        imageView = findViewById(R.id.Loupe)
        imageView.visibility = View.GONE
    }

    //Close Search Tools
    @Suppress("UNUSED_PARAMETER")
    fun closeSearchTools(view: View) {
        val constraintLayout: ConstraintLayout = findViewById(R.id.Search_Menu)
        constraintLayout.visibility = View.GONE
        var imageView: ImageView = findViewById(R.id.Loupe_Background)
        imageView.visibility = View.VISIBLE
        imageView = findViewById(R.id.Loupe)
        imageView.visibility = View.VISIBLE
    }

    //Changing Jobs to Bios
    @Suppress("UNUSED_PARAMETER")
    fun bioToJobs(view: View) {
        currentTypeSearch = 0

        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.visibility = View.VISIBLE
        recycler= findViewById(R.id.recycler_bios)
        recycler.visibility = View.GONE
    }

    //Changing Bios to Jobs
    @Suppress("UNUSED_PARAMETER")
    fun jobsToBios(view: View) {
        currentTypeSearch = 1

        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.visibility = View.GONE
        recycler= findViewById(R.id.recycler_bios)
        recycler.visibility = View.VISIBLE
    }

    //    ---

    //Asynchronous Load data from ModelFromConnection Class
    private inner class ReadModelFromConnection : Runnable {
        override fun run() {
            val message = handler.obtainMessage()

            try {
                if (currentTypeSearch == 0){
                    modelManager.loadOpportunities(20, cardList_Opportunities.size)
                    message.obj = ThreadReadType.Opportunities_Loaded
                } else if (currentTypeSearch == 1){
                    modelManager.loadPeoples(20, cardList_Peoples.size)
                    message.obj = ThreadReadType.Peoples_Loaded
                } else if (currentTypeSearch == 2){
                    modelManager.loadJob(nameSearch)
                    message.obj = ThreadReadType.Job_Loaded
                } else {
                    modelManager.loadBio(nameSearch)
                    message.obj = ThreadReadType.Bio_Loaded
                }
            } catch (e: ConnectionException) {
                message.obj = ThreadReadType.Load_Failed
            }
            handler.sendMessage(message)
//            handler.sendMessageAtFrontOfQueue(message)
        }
    }

    //Asynchronous Load data from ModelFromConnection Class
    private inner class ReadBothModelFromConnection : Runnable {
        override fun run() {
            val message = handler.obtainMessage()
            try {
                modelManager.loadOpportunities(20, cardList_Opportunities.size)
                val message1 = handler.obtainMessage()
                message1.obj = ThreadReadType.Opportunities_Loaded
//                handler.sendMessage(message1)
                handler.sendMessageAtFrontOfQueue(message1)
                modelManager.loadPeoples(20, cardList_Peoples.size)
                val message2 = handler.obtainMessage()
                message2.obj = ThreadReadType.Peoples_Loaded
//                handler.sendMessage(message2)
                handler.sendMessageAtFrontOfQueue(message2)
            } catch (e: ConnectionException) {
                message.obj = ThreadReadType.Load_Failed
                handler.sendMessageAtFrontOfQueue(message)
            }
        }
    }

    //Handle the actions when ready to update the ui
    @Suppress("DEPRECATION")
    @SuppressLint("HandlerLeak")
    private val handler: Handler = object : Handler() {
        override fun handleMessage(message: Message) {
            if (message.obj != null) {
                if (message.obj.equals(ThreadReadType.Opportunities_Loaded)) {
                    loadOpportunityCards()
                } else if (message.obj.equals(ThreadReadType.Peoples_Loaded)) {
                    loadPeopleCards()
                } else if (message.obj.equals(ThreadReadType.Job_Loaded)) {
                    loadJobData()
                } else if (message.obj.equals(ThreadReadType.Bio_Loaded)) {
                    loadBioData()
//            } else if (message.obj.equals(ThreadReadType.Image_Loaded)){
//                cardList_Opportunities.
                }

                val imageView = findViewById<ImageView>(R.id.loading)
                imageView.visibility = View.GONE
            }
        }
    }

    //    ---

    fun loadOpportunityCards() {
        val size: Int = cardList_Opportunities.size
//        val threadlist = arrayOfNulls<Thread>(20)

        for (i in 0..19) {
            val resultItem = modelManager.nextOpportunity()
            val cardOpportunities = CardItem_Opportunities(resultItem)
            cardOpportunities.image = BitmapFromConnection.getBitmap(resultItem.id)
            cardList_Opportunities.add(cardOpportunities)

//            bitmapInfo.push(arrayOf(resultItem.id, resultItem.organizations[0].picture))

//            threadlist[i] = Thread(ReadBitmapFromConnection())
//            if (!threadlist[i]?.isAlive!!) {
//                threadlist[i]?.start()
//            }

        }

        adapter_Opportunities.notifyItemRangeInserted(size, 20)
    }

    fun loadPeopleCards() {
        val size: Int = cardList_Peoples.size

        for (i in 0..19)
            cardList_Peoples.add(CardItem_Peoples(modelManager.nextPeople()))

        adapter_Peoples.notifyItemRangeInserted(size, 20)
    }

    fun loadJobData() {
        //todo
    }

    fun loadBioData() {
        //todo
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
    fun authorSelected(view: View?) {
        val constraintLayout = findViewById<ConstraintLayout>(R.id.author)
        constraintLayout.visibility = View.GONE
    }
}