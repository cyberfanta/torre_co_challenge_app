package com.cyberfanta.torre_co_challenge_app.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.BitmapFromConnection
import com.cyberfanta.torre_co_challenge_app.controllers.ModelManager
import com.cyberfanta.torre_co_challenge_app.models.bio.DataItem

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
        var constraintLayout: ConstraintLayout

        //image_bio
        var imageView: ImageView = findViewById(R.id.image_bio)
        imageView.setImageBitmap(BitmapFromConnection.getBitmap(bio.person.publicId))

        //name_bio
        var textView: TextView = findViewById(R.id.name_bio)
        textView.text = bio.person.name

        //highlight_bio
        textView = findViewById(R.id.highlight_bio)
        var string: String = bio.person.professionalHeadline
        textView.text = string

        //summary_bio
        if (bio.person.summaryOfBio == null || bio.person.summaryOfBio.isBlank()) {
            constraintLayout = findViewById(R.id.summary_bio)
            constraintLayout.visibility = View.GONE
        } else {
            textView = findViewById(R.id.skill_1_bio)
            string = bio.person.summaryOfBio
            textView.text = string
        }

        //strengths_bio
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

        //experience_bio
        if (bio.experiences.size < 1) {
            constraintLayout = findViewById(R.id.experience_bio)
            constraintLayout.visibility = View.GONE
        } else {
            for (i in 0 until bio.experiences.size) {
                val linearLayoutContainer : LinearLayout = findViewById(R.id.experience_bio_container)

                textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                val layoutParamsEducation : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                textView.layoutParams = layoutParamsEducation
                string = ViewUtilities.translateStrings(this, "category") + ": " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].category) + "\n" +
                        ViewUtilities.translateStrings(this, "name") + ": " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].name) + "\n" +
                        ViewUtilities.translateStrings(this, "from") + ": " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].fromMonth) + " " +
                        ViewUtilities.translateStrings(this, bio.experiences[i].fromYear)
                if (bio.experiences[i].toMonth != null && bio.experiences[i].category != null) {
                    string += "\n" + ViewUtilities.translateStrings(this, "to") + ": " +
                            ViewUtilities.translateStrings(this, bio.experiences[i].toMonth) + " " +
                            ViewUtilities.translateStrings(this, bio.experiences[i].toYear)
                }
                if (bio.experiences[i].isRemote)
                    string +=  "\n" + ViewUtilities.translateStrings(this, "remote")
                textView.text = string
                linearLayoutContainer.addView(textView)

                if (bio.experiences[i].organizations.size > 0) {
                    string += "\n" + ViewUtilities.translateStrings(this, "organizations") + ":"
                    textView.text = string
                    for (j in 0 until bio.experiences[i].organizations.size) {
                        val linearLayout = LinearLayout(this)
                        linearLayout.orientation = LinearLayout.HORIZONTAL
                        val layoutParamsOrganization: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                        if (j != bio.experiences[i].organizations.size)
                            layoutParamsOrganization.setMargins(0, 0, 0, 2)
                        else
                            layoutParamsOrganization.setMargins(0, 0, 0, 40)
                        linearLayout.layoutParams = layoutParamsOrganization

                        textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                        textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, .9f)
                        string = bio.experiences[i].organizations[j].name
                        textView.maxLines = 2
                        textView.text = string
                        linearLayout.addView(textView)

                        imageView = ImageView(this)
                        imageView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, .1f)
                        imageView.setImageBitmap(BitmapFromConnection.getBitmap(bio.experiences[i].organizations[j].name))
                        imageView.maxHeight = 130
                        imageView.maxWidth = 130
                        imageView.adjustViewBounds = true
                        linearLayout.addView(imageView)

                        string += "\n"
                        linearLayoutContainer.addView(linearLayout)
                    }
                } else {
                    layoutParamsEducation.bottomMargin = 40
                }
            }
            if (bio.experiences.size > 0)
                string = string.substring(0, string.length - 2)
            textView.text = string
        }

        //education_bio
        if (bio.education.size < 1) {
            constraintLayout = findViewById(R.id.education_bio)
            constraintLayout.visibility = View.GONE
        } else {
            for (i in 0 until bio.education.size) {
                val linearLayoutContainer : LinearLayout = findViewById(R.id.education_bio_container)

                textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                val layoutParamsEducation : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                textView.layoutParams = layoutParamsEducation
                string = ViewUtilities.translateStrings(this, "category") + ": " +
                        ViewUtilities.translateStrings(this, bio.education[i].category) + "\n" +
                        ViewUtilities.translateStrings(this, "name") + ": " +
                        ViewUtilities.translateStrings(this, bio.education[i].name) + "\n" +
                        ViewUtilities.translateStrings(this, "from") + ": " +
                        ViewUtilities.translateStrings(this, bio.education[i].fromMonth) + " " +
                        ViewUtilities.translateStrings(this, bio.education[i].fromYear)
                if (bio.education[i].isRemote)
                    string +=  "\n" + ViewUtilities.translateStrings(this, "remote")
                textView.text = string
                linearLayoutContainer.addView(textView)

                if (bio.education[i].organizations.size > 0) {
                    string += "\n" + ViewUtilities.translateStrings(this, "organizations") + ":"
                    textView.text = string
                    for (j in 0 until bio.education[i].organizations.size) {
                        val linearLayout = LinearLayout(this)
                        linearLayout.orientation = LinearLayout.HORIZONTAL
                        val layoutParamsOrganization: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                        if (j != bio.education[i].organizations.size)
                            layoutParamsOrganization.setMargins(0, 0, 0, 2)
                        else
                            layoutParamsOrganization.setMargins(0, 0, 0, 40)
                        linearLayout.layoutParams = layoutParamsOrganization

                        textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                        textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, .9f)
                        string = bio.education[i].organizations[j].name
                        textView.maxLines = 2
                        textView.text = string
                        linearLayout.addView(textView)

                        imageView = ImageView(this)
                        imageView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, .1f)
                        imageView.setImageBitmap(BitmapFromConnection.getBitmap(bio.education[i].organizations[j].name))
                        imageView.maxHeight = 130
                        imageView.maxWidth = 130
                        imageView.adjustViewBounds = true
                        linearLayout.addView(imageView)

                        string += "\n"
                        linearLayoutContainer.addView(linearLayout)
                    }
                } else {
                    layoutParamsEducation.bottomMargin = 40
                }
            }
        }

        //languages_bio
        if (bio.languages.size < 1) {
            constraintLayout = findViewById(R.id.languages_bio)
            constraintLayout.visibility = View.GONE
        } else {
            textView = findViewById(R.id.skill_3_bio)
            string = ""
            for (i in 0 until bio.languages.size) {
                string += ViewUtilities.translateStrings(this, bio.languages[i].language) + ": " +
                        ViewUtilities.translateStrings(this, bio.languages[i].fluency) + "\n"
            }
            if (bio.languages.size > 0)
                string = string.substring(0, string.length - 1)
            textView.text = string
        }

//personality_bio
//culture_bio

        //opportunities_bio
        if (bio.opportunities.size < 1) {
            constraintLayout = findViewById(R.id.opportunities_bio)
            constraintLayout.visibility = View.GONE
        } else {
            val linearLayout : LinearLayout = findViewById(R.id.opportunities_bio_container)
            for (i in 0 until bio.opportunities.size) {
                if (bio.opportunities[i].data is List<*>) {
                    textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                    textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    string = ViewUtilities.translateStrings(this, bio.opportunities[i].interest) + ": "
                    @Suppress("UNCHECKED_CAST")
                    for (j in 0 until (bio.opportunities[i].data as List<*>).size)
                        string += ViewUtilities.translateStrings(this, bio.opportunities[i].dataList[j].name) + ", "
                    if (bio.opportunities[i].dataList.size > 0)
                        string = string.substring(0, string.length - 2)
                    textView.text = string
                    linearLayout.addView(textView)
                } else {
                    textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                    textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    string = ViewUtilities.translateStrings(this, bio.opportunities[i].interest) +
                            " - " + ViewUtilities.translateStrings(this, bio.opportunities[i].field) +
                            " - " + ViewUtilities.translateStrings(this, bio.opportunities[i].data.toString())
                    textView.text = string
                    linearLayout.addView(textView)
                }
            }
        }

        //links_bio
        if (bio.person.links.size < 1) {
            constraintLayout = findViewById(R.id.links_bio)
            constraintLayout.visibility = View.GONE
        } else {
            val linearLayoutContainer : LinearLayout = findViewById(R.id.links_bio_container)
            for (i in 0 until bio.person.links.size) {
                val linearLayout = LinearLayout(this)
                linearLayout.orientation = LinearLayout.HORIZONTAL
                val layoutParamsOrganization: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                if (i != bio.person.links.size)
                    layoutParamsOrganization.setMargins(0, 0, 0, 30)
                else
                    layoutParamsOrganization.setMargins(0, 0, 0, 40)
                linearLayout.layoutParams = layoutParamsOrganization

                textView = TextView(this, null, 0, R.style.text_white_shadow_black_3_size_18_bold)
                textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                string = bio.person.links[i].name + ": "
                textView.text = string
                linearLayout.addView(textView)

                textView = TextView(this, null, 0, R.style.text_yellow_shadow_black_3_size_18_bold)
                textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                textView.text = bio.person.links[i].address
                textView.setOnClickListener {
                    hyperlink(bio.person.links[i].address)
                }
                linearLayout.addView(textView)
                linearLayoutContainer.addView(linearLayout)
            }
        }

        //location_bio
        textView = findViewById(R.id.skill_4_bio)
        string = ViewUtilities.translateStrings(this, "city") + ": " +
                bio.person.location.name + "\n" +
                ViewUtilities.translateStrings(this, "country") + ": " +
                bio.person.location.country + "\n" +
                ViewUtilities.translateStrings(this, "latitude") + ": " +
                bio.person.location.latitude + "\n" +
                ViewUtilities.translateStrings(this, "longitude") + ": " +
                bio.person.location.longitude + "\n" +
                ViewUtilities.translateStrings(this, "timezone") + ": " +
                bio.person.location.timezone + "\n" +
                ViewUtilities.translateStrings(this, "timezone_offset") + ": " +
                bio.person.location.timezoneOffSet
        textView.text = string

//interests_bio
//jobs_bio
//projects_bio
//publications_bio
    }

    //Open hyperlinks
    fun hyperlink(string: String) {
        val uri = Uri.parse(string)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
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