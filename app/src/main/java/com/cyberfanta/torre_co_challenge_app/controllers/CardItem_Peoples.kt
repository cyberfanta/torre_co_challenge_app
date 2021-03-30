package com.cyberfanta.torre_co_challenge_app.controllers

import android.graphics.Bitmap
import android.util.Log
import com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem
import java.util.*

class CardItem_Peoples {
    private val TAG = "CardItem_Peoples"

    var name: String? = null
    var image: Bitmap? = null
    var image_url: String? = null
    var highligth: String? = null
    var time1: String? = null
    var time2: String? = null
    var time3: String? = null
    var time4: String? = null
    var skill1: String? = null
    var skill2: String? = null
    var skill3: String? = null
    var skill4: String? = null
    var skill5: String? = null
    var skill6: String? = null
    var skill7: String? = null
    var skill8: String? = null

    constructor(resultsItem: ResultsItem) {
        Log.i(TAG, resultsItem.toString())

        name = resultsItem.name
        if  (resultsItem.picture != null)
            image_url = resultsItem.picture
        else
            image_url = null

        if  (resultsItem.professionalHeadline != null)
            highligth = resultsItem.professionalHeadline
        else
            highligth = " "

        if (resultsItem.openTo.size > 0) {
            time1 = if (resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("full")) "Full Time"
            else
                if (resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("free")) "Freelance"
                else
                    if (resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("part")) "Part Time"
                    else
                        if (resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("advis")) "Advisor"
                        else ""

            if (resultsItem.openTo.size > 1) {
                time2 = if (resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("full")) "Full Time"
                else
                    if (resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("free")) "Freelance"
                    else
                        if (resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("part")) "Part Time"
                        else
                            if (resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("advis")) "Advisor"
                            else ""

                if (resultsItem.openTo.size > 2) {
                    time3 = if (resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("full")) "Full Time"
                    else
                        if (resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("free")) "Freelance"
                        else
                            if (resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("part")) "Part Time"
                            else
                                if (resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("advis")) "Advisor"
                                else ""

                    if (resultsItem.openTo.size > 3) {
                        time4 = if (resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("full")) "Full Time"
                        else
                            if (resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("free")) "Freelance"
                            else
                                if (resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("part")) "Part Time"
                                else
                                    if (resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("advis")) "Advisor"
                                    else ""
                    }
                }
            }
        }

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

    constructor(name: String, image_url: String, highligth: String, time1: String, time2: String, time3: String, time4: String,
                skill1: String?, skill2: String?, skill3: String?, skill4: String?, skill5: String?, skill6: String?, skill7: String?, skill8: String?) {
        this.name = name
        this.image_url = image_url
        this.highligth = highligth
        this.time1 = time1
        this.time2 = time2
        this.time3 = time3
        this.time4 = time4
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
