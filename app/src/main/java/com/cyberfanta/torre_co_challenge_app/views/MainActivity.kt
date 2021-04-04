package com.cyberfanta.torre_co_challenge_app.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.DisplayMetrics
import android.view.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.*
import com.cyberfanta.torre_co_challenge_app.enumerator.ThreadReadType
import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException
import java.util.*


internal class MainActivity : AppCompatActivity() {
    private var deviceWidth: Int = 0
    private var deviceHeight:Int = 0

    private var currentTypeSearch: Int = 0 //0 = Opportunities , 1 = Peoples , 2 = Job , 3 = Bio

    private var currentIdSearch: String = ""

    private lateinit var modelManager: ModelManager

    private lateinit var adapterOpportunities: CardAdapterOpportunities
    private lateinit var adapterPeoples: CardAdapterPeoples

    private var cardListOpportunities: ArrayList<CardItemOpportunities>
    = ArrayList<CardItemOpportunities>(20)
    private var cardListPeople: ArrayList<CardItemPeoples>
    = ArrayList<CardItemPeoples>(20)

    private var queriesThread = Thread(ReadModelFromConnection())

    //    ---

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateDeviceDimensions()

        initializingRecyclersView()
        initializingConnectionController()
        initializingLoadingArrowAnimation()
    }

    override fun onStart() {
        super.onStart()

        fillBothRecyclersView()
    }

    override fun onBackPressed() {
        val constraintLayout : ConstraintLayout = findViewById(R.id.author)
        if (!constraintLayout.translationX.equals(deviceWidth.toFloat())) {
            authorSelected(constraintLayout)
            return
        }

        super.onBackPressed()
    }

    override fun onDestroy() {
        if (queriesThread.isAlive)
            queriesThread.interrupt()

        super.onDestroy()
    }

    //    ---

    //Calculate the device dimension
    private fun calculateDeviceDimensions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = getWindowManager().currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets
                    .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            deviceWidth = windowMetrics.bounds.width() - insets.left - insets.right
            deviceHeight = windowMetrics.bounds.height() - insets.top - insets.bottom
        } else {
            val displayMetrics = DisplayMetrics()
            @Suppress("DEPRECATION")
            getWindowManager().defaultDisplay.getMetrics(displayMetrics)
            deviceWidth = displayMetrics.widthPixels
            deviceHeight = displayMetrics.heightPixels
        }
    }

    //Initialize the recyclerView
    private fun initializingRecyclersView() {
        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.setHasFixedSize(true)
        val layoutManager_Opportunities: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapterOpportunities = CardAdapterOpportunities(cardListOpportunities)
        recycler.layoutManager = layoutManager_Opportunities
        recycler.adapter = adapterOpportunities

        adapterOpportunities.setOnItemClickListener(object :
            CardAdapterOpportunities.OnItemClickListener {
            override fun onItemClick(position: Int) {
                currentIdSearch = cardListOpportunities[position].id.toString()
                currentTypeSearch = 2
                queryFromApi()
            }
        })

        adapterOpportunities.setOnBottomReachedListener(object :
            CardAdapterOpportunities.OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                val imageView = findViewById<ImageView>(R.id.loading)
                imageView.visibility = View.VISIBLE

                currentTypeSearch = 0
                queryFromApi()
            }
        })

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    currentTypeSearch = 0
                    queryFromApi()
                }
            }
        })

        //        ---

        recycler = findViewById(R.id.recycler_bios)
        recycler.setHasFixedSize(true)
        val layoutManager_Peoples: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapterPeoples = CardAdapterPeoples(cardListPeople)
        recycler.layoutManager = layoutManager_Peoples
        recycler.adapter = adapterPeoples

        adapterPeoples.setOnItemClickListener(object : CardAdapterPeoples.OnItemClickListener {
            override fun onItemClick(position: Int) {
                currentIdSearch = cardListPeople[position].id.toString()
                currentTypeSearch = 3
                queryFromApi()
            }
        })

        adapterPeoples.setOnBottomReachedListener(object :
            CardAdapterPeoples.OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                val imageView = findViewById<ImageView>(R.id.loading)
                imageView.visibility = View.VISIBLE

                currentTypeSearch = 1
                queryFromApi()
            }
        })

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    currentTypeSearch = 1
                    queryFromApi()
                }
            }
        })
    }

    //Initialize the Connection Controller
    private fun initializingConnectionController() {
        modelManager = ModelManager()
    }

    //Initialize loading arrow animation
    private fun initializingLoadingArrowAnimation() {
        val imageView = findViewById<ImageView>(R.id.loading)
        setAnimation(imageView, "rotation", 1000, true, 0f, 360f)
    }

    //Set animation on view
    private fun setAnimation(view: View, propertyName: String, duration: Long, repeat: Boolean, value1: Float, value2: Float) {
        val objectAnimator = ObjectAnimator.ofFloat(view, propertyName, value1, value2)
        val animator = AnimatorSet()
        animator.play(objectAnimator)
        animator.duration = duration
        if (repeat) {
            animator.addListener(
                object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        animator.start()
                    }
                }
            )
        }
        animator.start()
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
    private fun queryFromApi() {
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

        var imageView : ImageView = findViewById(R.id.Jobs_Selector)
        imageView.visibility = View.VISIBLE
        imageView = findViewById(R.id.Bios_Selector)
        imageView.visibility = View.GONE
    }

    //Changing Bios to Jobs
    @Suppress("UNUSED_PARAMETER")
    fun jobsToBios(view: View) {
        currentTypeSearch = 1

        var recycler: RecyclerView = findViewById(R.id.recycler_jobs)
        recycler.visibility = View.GONE
        recycler= findViewById(R.id.recycler_bios)
        recycler.visibility = View.VISIBLE

        var imageView : ImageView = findViewById(R.id.Jobs_Selector)
        imageView.visibility = View.GONE
        imageView = findViewById(R.id.Bios_Selector)
        imageView.visibility = View.VISIBLE
    }

    //    ---

    //Asynchronous Load data from ModelFromConnection Class
    private inner class ReadModelFromConnection : Runnable {
        override fun run() {
            val message = handler.obtainMessage()

            try {
                if (currentTypeSearch == 0){
                    modelManager.loadOpportunities(20, cardListOpportunities.size)
                    message.obj = ThreadReadType.Opportunities_Loaded
                } else if (currentTypeSearch == 1){
                    modelManager.loadPeoples(20, cardListPeople.size)
                    message.obj = ThreadReadType.Peoples_Loaded
                } else if (currentTypeSearch == 2){
                    modelManager.loadJob(currentIdSearch)
                    message.obj = ThreadReadType.Job_Loaded
                } else {
                    modelManager.loadBio(currentIdSearch)
                    message.obj = ThreadReadType.Bio_Loaded
                }
            } catch (e: ConnectionException) {
                message.obj = ThreadReadType.Load_Failed
            }
            handler.sendMessageAtFrontOfQueue(message)
        }
    }

    //Asynchronous Load data from ModelFromConnection Class
    private inner class ReadBothModelFromConnection : Runnable {
        override fun run() {
            val message = handler.obtainMessage()
            try {
                modelManager.loadOpportunities(20, cardListOpportunities.size)
                val message1 = handler.obtainMessage()
                message1.obj = ThreadReadType.Opportunities_Loaded
                handler.sendMessageAtFrontOfQueue(message1)
                modelManager.loadPeoples(20, cardListPeople.size)
                val message2 = handler.obtainMessage()
                message2.obj = ThreadReadType.Peoples_Loaded
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
                }

                val imageView = findViewById<ImageView>(R.id.loading)
                imageView.visibility = View.GONE
            }
        }
    }

    //    ---

    fun loadOpportunityCards() {
        val size: Int = cardListOpportunities.size

        for (i in 0..19) {
            val resultItem = modelManager.nextOpportunity()
            val cardOpportunities = CardItemOpportunities(resultItem)
            cardOpportunities.image = BitmapFromConnection.getBitmap(resultItem.id)
            cardListOpportunities.add(cardOpportunities)
        }

        adapterOpportunities.notifyItemRangeInserted(size, 20)
    }

    fun loadPeopleCards() {
        val size: Int = cardListPeople.size

        for (i in 0..19) {
            val resultItem = modelManager.nextPeople()
            val cardPeoples = CardItemPeoples(resultItem)
            cardPeoples.image = BitmapFromConnection.getBitmap(resultItem.username)
            cardListPeople.add(cardPeoples)
        }

        adapterPeoples.notifyItemRangeInserted(size, 20)
    }

    fun loadJobData() {
        val intent = Intent(this, OpportunityActivity::class.java)
        val bundle = Bundle()
        bundle.putString("deviceWidth", deviceWidth.toString())
        bundle.putString("deviceHeight", deviceHeight.toString())
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun loadBioData() {
        //todo
    }

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
            setAnimation(constraintLayout, "translationX", 300, false, deviceWidth.toFloat(), 0f)
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
        setAnimation(constraintLayout, "translationX", 300, false, 0f, deviceWidth.toFloat())
//        constraintLayout.visibility = View.GONE
    }
}