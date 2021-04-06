package com.cyberfanta.torre_co_challenge_app.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.BitmapFromConnection
import com.cyberfanta.torre_co_challenge_app.views.ViewUtilities.filterWebAnnotations
import com.cyberfanta.torre_co_challenge_app.controllers.ModelManager
import com.cyberfanta.torre_co_challenge_app.views.ViewUtilities.translateStrings
import java.util.*

class JobActivity : AppCompatActivity() {
    private var deviceWidth: Int = 0
    private var deviceHeight:Int = 0
    private var currentIdSearch: String = ""

    private var authorOpened: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)

        getDeviceDimensions()
        loadObject()
    }

    override fun onBackPressed() {
        val constraintLayout : ConstraintLayout = findViewById(R.id.author)
        if (authorOpened) {
            authorSelected(constraintLayout)
            authorOpened = false
            return
        }

        super.onBackPressed()
    }

    //    ---

    //Get the device dimension
    private fun getDeviceDimensions(){
        deviceWidth = intent.getStringExtra("deviceWidth")!!.toInt()
        deviceHeight = intent.getStringExtra("deviceHeight")!!.toInt()
        currentIdSearch = intent.getStringExtra("currentIdSearch")!!
    }

    //Load object from controller and show it in the view
    private fun loadObject(){
        val modelManager = ModelManager()
        val job = modelManager.getJob(currentIdSearch)

        val imageView: ImageView = findViewById(R.id.image_job)
        imageView.setImageBitmap(BitmapFromConnection.getBitmap(job.id))

        //        ---

        var textView: TextView = findViewById(R.id.name_job)
        textView.text = job.objective

        //        ---

        textView = findViewById(R.id.highlight_job)
        var string: String = job.compensation.minAmount.toString()
        if (job.compensation.maxAmount != 0)
            string += " - " + job.compensation.maxAmount.toString()
        string += " " + job.compensation.currency + " " + job.compensation.periodicity
        textView.text = string

        //        ---

        textView = findViewById(R.id.skill_1_job)
        string = ""
        for (i in 0 until job.strengths.size) {
            if (job.strengths[i].experience.contains("plus-year"))
                string += job.strengths[i].name + ": " +
//                        translateAnnotations(this, "plus_year_1") + " " +
                        job.strengths[i].experience.substring(0, 1) + "+ " +
                        translateStrings(this, "plus_year_2") + "\n"
            else if (job.strengths[i].experience.contains("potential-to-develop"))
                string += job.strengths[i].name + ": " + translateStrings(this, "potential_to_develop") + "\n"
            else
                string += job.strengths[i].name + ": " + job.strengths[i].experience + "\n"
        }

        if (job.strengths.size > 0)
            string = string.substring(0, string.length - 1)
        textView.text = string

        //        ---

        textView = findViewById(R.id.skill_2_job)
        string = ""
        if (job.place.isRemote)
            string += translateStrings(this, "remote") + "\n"

        if (job.place.isAnywhere)
            string += translateStrings(this, "anywhere") + "\n"
        else
            for (i in 0 until job.place.location.size)
                string += translateStrings(this, "in") + ": " + job.place.location[i].id + "\n"

        if (job.place.isTimezone)
            string += translateStrings(this, "remote") + "\n"

        for (i in 0 until job.serpTags.employmentType.size)
            string += translateStrings(this, "type") + ": " + job.serpTags.employmentType[i] + "\n"
        if (job.serpTags.employmentType.size > 0)
            string = string.substring(0, string.length - 1)
        textView.text = string

        //        ---

        textView = findViewById(R.id.skill_3_job)
        string = job.serpTags.description
        string = filterWebAnnotations(string)
        string = string.substring(0, string.length - 2)
        textView.text = string

        //        ---

        textView = findViewById(R.id.skill_4_job)
        string = ""
        for (i in 0 until job.details.size)
            string += translateStrings(this, job.details[i].code.toLowerCase(Locale.ROOT)).toUpperCase(Locale.ROOT) + ":\n" + job.details[i].content + "\n\n"
        if (job.details.size > 0)
            string = string.substring(0, string.length - 2)
        textView.text = string

        //        ---

        textView = findViewById(R.id.skill_5_job)
        string = ""
        for (i in 0 until job.languages.size)
            string += translateStrings(this, job.languages[i].language.name) + ": " + translateStrings(this, job.languages[i].fluency) + "\n"
        if (job.languages.size > 0)
            string = string.substring(0, string.length - 1)
        textView.text = string

        //        ---

        textView = findViewById(R.id.skill_6_job)
        if (job.organizations.size > 0)
            textView.text = job.serpTags.hiringOrganization.name
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