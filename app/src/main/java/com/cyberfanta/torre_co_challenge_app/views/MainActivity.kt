package com.cyberfanta.torre_co_challenge_app.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cyberfanta.torre_co_challenge_app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun defaultClickable(view: View) {
        //todo: delete as soon as possible
        Toast.makeText(applicationContext, view.id.toString(), Toast.LENGTH_SHORT).show()
    }
}