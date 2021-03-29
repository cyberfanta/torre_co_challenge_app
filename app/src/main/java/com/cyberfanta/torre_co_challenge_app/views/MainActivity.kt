package com.cyberfanta.torre_co_challenge_app.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    private var cardlist = ArrayList<CardBuilder>()
    private val recycler: RecyclerView = findViewById(R.id.recycler)
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun defaultClickable(view: View) {
        //todo: delete as soon as possible
        Toast.makeText(applicationContext, view.id.toString(), Toast.LENGTH_SHORT).show()
    }
}