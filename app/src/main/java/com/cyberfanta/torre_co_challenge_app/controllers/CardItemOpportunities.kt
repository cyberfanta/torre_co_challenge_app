package com.cyberfanta.torre_co_challenge_app.controllers

import android.graphics.Bitmap
import com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem
import java.util.*

class CardItemOpportunities(resultsItem: ResultsItem) {

    var id: String? = null
    var name: String? = null
    var image: Bitmap? = null
    private var imageUrl: String? = null
    var highligth: String? = null
    var time: String? = null
    var remote: String? = null
    var skill1: String? = null
    var skill2: String? = null
    var skill3: String? = null
    var skill4: String? = null
    var skill5: String? = null
    var skill6: String? = null
    var skill7: String? = null
    var skill8: String? = null

    init {
        id = resultsItem.id
        name = resultsItem.objective
        imageUrl = if  (resultsItem.organizations.size > 0)
            resultsItem.organizations[0].picture
        else
            null
        if  (resultsItem.compensation.data != null) {
            highligth = resultsItem.compensation.data.minAmount.toInt().toString()
            if (resultsItem.compensation.data.maxAmount.toInt().toString() != "0")
                highligth = highligth + " - " + resultsItem.compensation.data.maxAmount.toInt().toString()
            highligth = highligth + " " + resultsItem.compensation.data.currency + " " + resultsItem.compensation.data.periodicity
        } else
            highligth = " "
        time =
                when {
                    resultsItem.type.toLowerCase(Locale.ROOT).contains("full") -> "Full Time"
                    resultsItem.type.toLowerCase(Locale.ROOT).contains("free") -> "Freelance"
                    resultsItem.type.toLowerCase(Locale.ROOT).contains("part") -> "Part Time"
                    resultsItem.type.toLowerCase(Locale.ROOT).contains("advis") -> "Advisor"
                    else -> ""
                }
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
}
