package com.cyberfanta.torre_co_challenge_app.controllers

import android.graphics.Bitmap
import android.util.Log
import com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem

class CardItem {
    private val TAG = "CardItem"

    val name: String
    var image: Bitmap? = null
    val image_url: String
    val highligth: String
    val time: String
    val remote: String
    var skill1: String? = null
        private set
    var skill2: String? = null
        private set
    var skill3: String? = null
        private set
    var skill4: String? = null
        private set
    var skill5: String? = null
        private set
    var skill6: String? = null
        private set
    var skill7: String? = null
        private set
    var skill8: String? = null
        private set

    constructor(resultsItem: ResultsItem) {
        Log.i(TAG, resultsItem.toString())

        name = resultsItem.objective
        image_url = resultsItem.organizations[0].picture
        if  (resultsItem.compensation.data != null)
            highligth = resultsItem.compensation.data.minAmount.toString() + " " + resultsItem.compensation.data.maxAmount + " " + resultsItem.compensation.data.currency + " " + resultsItem.compensation.data.periodicity
        else
            highligth = " "

        time = resultsItem.type
        remote = if (resultsItem.isRemote) "Remote" else "No Remote"
        for (i in resultsItem.skills.indices) {
            if (i == 0) skill1 = resultsItem.skills[0].name
            if (i == 1) skill2 = resultsItem.skills[1].name
            if (i == 2) skill3 = resultsItem.skills[2].name
            if (i == 3) skill4 = resultsItem.skills[3].name
            if (i == 4) skill5 = resultsItem.skills[4].name
            if (i == 5) skill6 = resultsItem.skills[5].name
            if (i == 6) skill7 = resultsItem.skills[6].name
            if (i == 7) skill8 = resultsItem.skills[7].name
        }
    }

    constructor(name: String, image_url: String, highligth: String, time: String, remote: String, skill1: String?, skill2: String?, skill3: String?, skill4: String?, skill5: String?, skill6: String?, skill7: String?, skill8: String?) {
        this.name = name
        this.image_url = image_url
        this.highligth = highligth
        this.time = time
        this.remote = remote
        this.skill1 = skill1
        this.skill2 = skill2
        this.skill3 = skill3
        this.skill4 = skill4
        this.skill5 = skill5
        this.skill6 = skill6
        this.skill7 = skill7
        this.skill8 = skill8
    }
}