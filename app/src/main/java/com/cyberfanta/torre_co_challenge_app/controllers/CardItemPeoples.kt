package com.cyberfanta.torre_co_challenge_app.controllers

import android.graphics.Bitmap
import com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem
import java.util.*

class CardItemPeoples(resultsItem: ResultsItem) {

    var id: String? = null
    var name: String? = null
    var image: Bitmap? = null
    private var imageUrl: String? = null
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

    init {
        id = resultsItem.username
        name = resultsItem.name
        imageUrl = if  (resultsItem.picture != null)
            resultsItem.picture
        else
            null
        highligth = if  (resultsItem.professionalHeadline != null)
            resultsItem.professionalHeadline
        else
            " "
        if (resultsItem.openTo.size > 0) {
            time1 = when {
                resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("full") -> "Full Time"
                resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("free") -> "Freelance"
                resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("part") -> "Part Time"
                resultsItem.openTo[0].toLowerCase(Locale.ROOT).contains("advis") -> "Advisor"
                else -> ""
            }

            if (resultsItem.openTo.size > 1) {
                time2 = when {
                    resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("full") -> "Full Time"
                    resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("free") -> "Freelance"
                    resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("part") -> "Part Time"
                    resultsItem.openTo[1].toLowerCase(Locale.ROOT).contains("advis") -> "Advisor"
                    else -> ""
                }

                if (resultsItem.openTo.size > 2) {
                    time3 = when {
                        resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("full") -> "Full Time"
                        resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("free") -> "Freelance"
                        resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("part") -> "Part Time"
                        resultsItem.openTo[2].toLowerCase(Locale.ROOT).contains("advis") -> "Advisor"
                        else -> ""
                    }

                    if (resultsItem.openTo.size > 3) {
                        time4 = when {
                            resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("full") -> "Full Time"
                            resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("free") -> "Freelance"
                            resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("part") -> "Part Time"
                            resultsItem.openTo[3].toLowerCase(Locale.ROOT).contains("advis") -> "Advisor"
                            else -> ""
                        }
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
}
