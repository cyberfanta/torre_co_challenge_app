package com.cyberfanta.torre_co_challenge_app.controllers

import android.graphics.Bitmap

class CardItem(
        private var name: String,
        private var highligth: String,
        private var time: String,
        private var remote: String,
        private var skill1: String,
        private var skill2: String,
        private var skill3: String,
        private var skill4: String,
        private var skill5: String,
        private var skill6: String,
        private var skill7: String,
        private var skill8: String) {

    private var image: Bitmap? = null

    fun setImage(image: Bitmap) {
        this.image = image
    }

    fun getImage () : Bitmap? {
        return this.image
    }

    fun getName(): String {
        return this.name
    }

    fun getHighligth(): String {
        return this.highligth
    }

    fun getTime(): String {
        return this.time
    }

    fun getRemote(): String {
        return this.remote
    }

    fun getSkill1(): String {
        return this.skill1
    }

    fun getSkill2(): String {
        return this.skill2
    }

    fun getSkill3(): String {
        return this.skill3
    }

    fun getSkill4(): String {
        return this.skill4
    }

    fun getSkill5(): String {
        return this.skill5
    }

    fun getSkill6(): String {
        return this.skill6
    }

    fun getSkill7(): String {
        return this.skill7
    }

    fun getSkill8(): String {
        return this.skill8
    }
}