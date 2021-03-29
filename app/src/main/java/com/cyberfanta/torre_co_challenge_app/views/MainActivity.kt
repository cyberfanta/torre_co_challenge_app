package com.cyberfanta.torre_co_challenge_app.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter
import com.cyberfanta.torre_co_challenge_app.controllers.CardItem
import java.util.*

class MainActivity : AppCompatActivity() {
    private var cardlist = ArrayList<CardItem>()
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardlist.add(CardItem(
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
                ""))

        recycler = findViewById(R.id.recycler)
        recycler.setHasFixedSize(true)
        layoutManager = GridLayoutManager(this, 2)
        adapter = CardAdapter(cardlist)

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

    }

    fun defaultClickable(view: View) {
        //todo: delete as soon as possible
        Toast.makeText(applicationContext, view.id.toString(), Toast.LENGTH_SHORT).show()
    }
}