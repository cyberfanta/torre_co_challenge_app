package com.cyberfanta.torre_co_challenge_app.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.BitmapFromConnection
import com.cyberfanta.torre_co_challenge_app.controllers.ModelManager

class BioActivity : AppCompatActivity() {
    private var deviceWidth: Int = 0
    private var deviceHeight: Int = 0
    private var currentIdSearch: String = ""

    private var authorOpened: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        getDeviceDimensions()
        loadObject()
    }

    override fun onBackPressed() {
        val constraintLayout: ConstraintLayout = findViewById(R.id.author)
        if (authorOpened) {
            authorSelected(constraintLayout)
            authorOpened = false
            return
        }

        super.onBackPressed()
    }

    //    ---

    //Get the device dimension
    private fun getDeviceDimensions() {
        deviceWidth = intent.getStringExtra("deviceWidth")!!.toInt()
        deviceHeight = intent.getStringExtra("deviceHeight")!!.toInt()
        currentIdSearch = intent.getStringExtra("currentIdSearch")!!
    }

    //Load object from controller and show it in the view
    private fun loadObject() {
        val modelManager = ModelManager()
        val bio = modelManager.getBio(currentIdSearch)

        val imageView: ImageView = findViewById(R.id.image_bio)
        imageView.setImageBitmap(BitmapFromConnection.getBitmap(bio.person.publicId))

        //        ---

        var textView: TextView = findViewById(R.id.name_bio)
        textView.text = bio.person.name

        //        ---

        textView = findViewById(R.id.highlight_bio)
        var string: String = bio.person.professionalHeadline
        textView.text = string

        //        ---

        var constraintLayout: ConstraintLayout

        if (bio.person.summaryOfBio == null || bio.person.summaryOfBio.isBlank()) {
            constraintLayout = findViewById(R.id.summary_bio)
            constraintLayout.visibility = View.GONE
        } else {
            textView = findViewById(R.id.skill_1_bio)
            string = bio.person.summaryOfBio
            textView.text = string
        }

        //        ---

        if (bio.strengths.size < 1) {
            constraintLayout = findViewById(R.id.strengths_bio)
            constraintLayout.visibility = View.GONE
        } else {
            textView = findViewById(R.id.skill_2_bio)
            string = ""
            for (i in 0 until bio.strengths.size)
                string += bio.strengths[i].name + ", "
            if (bio.strengths.size > 0)
                string = string.substring(0, string.length - 2)
            textView.text = string

        }

        //        ---

        if (bio.experiences.size < 1) {
            constraintLayout = findViewById(R.id.experience_bio)
            constraintLayout.visibility = View.GONE
        } else {
            textView = findViewById(R.id.skill_3_bio)
            string = ""
            for (i in 0 until bio.experiences.size) {
                string += ViewUtilities.translateStrings(this, "category") + ": " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].category) + "\n" +
                        ViewUtilities.translateStrings(this, "name") + ": " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].name) + "\n" +
                        ViewUtilities.translateStrings(this, "from") + ": " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].fromMonth) + " " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].fromYear) + "\n"
                if (bio.experiences[i].toMonth != null && bio.experiences[i].category != null) {
                    string += ViewUtilities.translateStrings(this, "to") + ": " +
                            ViewUtilities.translateStrings(this, bio.experiences[i].toMonth) + " " +
                            ViewUtilities.translateStrings(this, bio.experiences[i].toYear) + "\n"
                }
                if (bio.experiences[i].organizations.size > 0) {
                    string += ViewUtilities.translateStrings(this, "organizations") + ":\n"
                    for (j in 0 until bio.experiences[i].organizations.size)
                        string += bio.experiences[i].organizations[j].name + "\n"
                }
                string += "\n"
            }
            if (bio.experiences.size > 0)
                string = string.substring(0, string.length - 2)
            textView.text = string

        }
    }

    //    ---

    //Set animation on view
    @Suppress("SameParameterValue")
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

    @Suppress("UNUSED_PARAMETER")
    fun returnClick(view: View) {
        finish()
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
            authorOpened = true
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
    }
}