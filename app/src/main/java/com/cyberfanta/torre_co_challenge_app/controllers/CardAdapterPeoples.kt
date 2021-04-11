package com.cyberfanta.torre_co_challenge_app.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapterPeoples.CardViewHolder
import java.util.*

class CardAdapterPeoples(private val cardList_People: ArrayList<CardItemPeoples>) : RecyclerView.Adapter<CardViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null
    private var bottomReachedListener: OnBottomReachedListener? = null

    //    ---

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnBottomReachedListener {
        fun onBottomReached(position: Int)
    }

    //    ---

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    fun setOnBottomReachedListener(listener: OnBottomReachedListener) {
        this.bottomReachedListener = listener
    }

    //    ---

    class CardViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var namePeople: TextView = itemView.findViewById(R.id.name_people)
        var imagePeople: ImageView = itemView.findViewById(R.id.image_people)
        var highligthPeople: TextView = itemView.findViewById(R.id.highligth_people)
        var time1: TextView = itemView.findViewById(R.id.time1)
        var time2: TextView = itemView.findViewById(R.id.time2)
        var time3: TextView = itemView.findViewById(R.id.time3)
        var time4: TextView = itemView.findViewById(R.id.time4)
        var skillPeople1: TextView = itemView.findViewById(R.id.skill1_people)
        var skillPeople2: TextView = itemView.findViewById(R.id.skill2_people)
        var skillPeople3: TextView = itemView.findViewById(R.id.skill3_people)
        var skillPeople4: TextView = itemView.findViewById(R.id.skill4_people)
        var skillPeople5: TextView = itemView.findViewById(R.id.skill5_people)
        var skillPeople6: TextView = itemView.findViewById(R.id.skill6_people)
        var skillPeople7: TextView = itemView.findViewById(R.id.skill7_people)
        var skillPeople8: TextView = itemView.findViewById(R.id.skill8_people)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_peoples, parent, false)
        return CardViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardList_People[position]
        holder.namePeople.text = cardItem.name
        if (cardItem.image != null)
            holder.imagePeople.setImageBitmap(cardItem.image)
        holder.highligthPeople.text = cardItem.highligth

        holder.time1.text = cardItem.time1
        holder.time2.text = cardItem.time2
        holder.time3.text = cardItem.time3
        holder.time4.text = cardItem.time4

        holder.skillPeople1.text = cardItem.skill1
        holder.skillPeople2.text = cardItem.skill2
        holder.skillPeople3.text = cardItem.skill3
        holder.skillPeople4.text = cardItem.skill4
        holder.skillPeople5.text = cardItem.skill5
        holder.skillPeople6.text = cardItem.skill6
        holder.skillPeople7.text = cardItem.skill7
        holder.skillPeople8.text = cardItem.skill8

        if (position > itemCount - 12)
            bottomReachedListener?.onBottomReached(position)
    }

    override fun getItemCount(): Int {
        return cardList_People.size
    }
}