@file:Suppress("DEPRECATION")

package com.cyberfanta.torre_co_challenge_app.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter.CardViewHolder
import com.cyberfanta.torre_co_challenge_app.controllers.CardItem
import com.cyberfanta.torre_co_challenge_app.controllers.ModelFromConnection
import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities
import java.util.*

internal class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var cardlist_Jobs: ArrayList<CardItem> = ArrayList<CardItem>(0)

    //    private var cardlist_Bios = ArrayList<CardItem>()
    private val currentTypeSearch = false //false = Jobs, true = Bios

    private var objectRetrived: Any? = null

    private var modelFromConnection: ModelFromConnection? = null
    private lateinit var url: Array<String>
    private lateinit var adapter: RecyclerView.Adapter<CardViewHolder>

    private var QueryThread = Thread(readModelFromConnection())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*cardlist.add(CardItem(
                "Android Developer",
                "1500$ - 3500$ Monthly",
                "Full Time",
                "Not Remote",
                "Java",
                "Kotlin",
                "Dart",
                "Flutter",
                "",
                "",
                "",
                ""))
        cardlist.add(CardItem(
                "Java Developer",
                "3500$ - 5000$ Monthly",
                "Partial Time",
                "Remote",
                "Java",
                "",
                "",
                "",
                "",
                "",
                "",
                ""))
        cardlist.add(CardItem(
                "Kot Developer",
                "3500$ - 5000$ Monthly",
                "Partial Time",
                "Remote",
                "Java",
                "Java",
                "Java",
                "Java",
                "",
                "",
                "",
                ""))*/
        initializingRecyclerView()
        initializingConnectionController()
        requestTwentyJobs()
    }

    //Initialize the recyclerView
    fun initializingRecyclerView() {
        val recycler: RecyclerView = findViewById(R.id.recycler)
        recycler.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        adapter = CardAdapter(cardlist_Jobs)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    //    //Initialize the recyclerView
    fun initializingConnectionController() {
        modelFromConnection = ModelFromConnection()
        url = arrayOf(
                "https://torre.bio/api/bios/",  //https://torre.bio/api/bios/$username
                "https://torre.co/api/opportunities/",  //https://torre.co/api/opportunities/$id
                "https://search.torre.co/people/_search/",  //https://search.torre.co/people/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
                "https://search.torre.co/opportunities/_search/" //https://search.torre.co/opportunities/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
        )
    }

    //Initial load for recicler view
    fun requestTwentyJobs() {
        if (!QueryThread.isAlive) {
            QueryThread = Thread(readModelFromConnection())
            QueryThread.start()
        }
    }

    //    void defaultClickable(View view) {
    //        //todo: delete as soon as possible
    //        Toast.makeText(applicationContext, view.id.toString(), Toast.LENGTH_SHORT).show()
    //        }

    //Load data from ModelFromConnection Class
    private inner class readModelFromConnection : Runnable {
        override fun run() {
            val message = handler.obtainMessage()
//            var `object`: Any? = null
            if (currentTypeSearch) {
                try {
//                    object = modelFromConnection.getObject(Bio.class, url[0] + "julioleon2004", "get");
                    objectRetrived = modelFromConnection!!.getObject(Opportunities::class.java, url[3], "post") as Nothing?
                } catch (e: ConnectionException) {
                    message.obj = "Error"
                }
            }
            message.obj = ""
            handler.sendMessageAtFrontOfQueue(message)
        }
    }

    //Handle the actions when ready to update the ui
    @SuppressLint("HandlerLeak")
    private val handler: Handler = object : Handler() {
        override fun handleMessage(message: Message) {
//            if (message.obj.getClass().isInstance(Bio.class)){
//
//            } else
            if (message.obj.equals("")) {
                insertOpportunities(objectRetrived as Opportunities)
            } else {
                Toast.makeText(this@MainActivity, "Error " + message.obj.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun insertOpportunities(opportunities: Opportunities) {
        cardlist_Jobs.add(CardItem(opportunities.results[0]))
        cardlist_Jobs.add(CardItem(opportunities.results[1]))
        cardlist_Jobs.add(CardItem(opportunities.results[2]))
        cardlist_Jobs.add(CardItem(opportunities.results[3]))
        cardlist_Jobs.add(CardItem(opportunities.results[4]))
        cardlist_Jobs.add(CardItem(opportunities.results[5]))
        cardlist_Jobs.add(CardItem(opportunities.results[6]))
        cardlist_Jobs.add(CardItem(opportunities.results[7]))
        cardlist_Jobs.add(CardItem(opportunities.results[8]))
        cardlist_Jobs.add(CardItem(opportunities.results[9]))
        cardlist_Jobs.add(CardItem(opportunities.results[10]))
        cardlist_Jobs.add(CardItem(opportunities.results[11]))
        cardlist_Jobs.add(CardItem(opportunities.results[12]))
        cardlist_Jobs.add(CardItem(opportunities.results[13]))
        cardlist_Jobs.add(CardItem(opportunities.results[14]))
        cardlist_Jobs.add(CardItem(opportunities.results[15]))
        cardlist_Jobs.add(CardItem(opportunities.results[16]))
        cardlist_Jobs.add(CardItem(opportunities.results[17]))
        cardlist_Jobs.add(CardItem(opportunities.results[18]))
        cardlist_Jobs.add(CardItem(opportunities.results[19]))

        adapter.notifyDataSetChanged()
    }
}