package com.cyberfanta.torre_co_challenge_app.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapterOpportunities.CardViewHolder
import java.util.*

class CardAdapterOpportunities(private val cardList_Opportunities: ArrayList<CardItemOpportunities>) : RecyclerView.Adapter<CardViewHolder>() {
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

    class CardViewHolder(itemView: View, itemClickListener: OnItemClickListener?) : RecyclerView.ViewHolder(
        itemView
    ) {
        var name: TextView = itemView.findViewById(R.id.name)
        var image: ImageView = itemView.findViewById(R.id.image)
        var highligth: TextView = itemView.findViewById(R.id.highligth)
        var time: TextView = itemView.findViewById(R.id.time)
        var remote: TextView = itemView.findViewById(R.id.remote)
        var skill1: TextView = itemView.findViewById(R.id.skill1)
        var skill2: TextView = itemView.findViewById(R.id.skill2)
        var skill3: TextView = itemView.findViewById(R.id.skill3)
        var skill4: TextView = itemView.findViewById(R.id.skill4)
        var skill5: TextView = itemView.findViewById(R.id.skill5)
        var skill6: TextView = itemView.findViewById(R.id.skill6)
        var skill7: TextView = itemView.findViewById(R.id.skill7)
        var skill8: TextView = itemView.findViewById(R.id.skill8)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_opportunities, parent, false)
        return CardViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardList_Opportunities[position]
        holder.name.text = cardItem.name
        if (cardItem.image != null)
            holder.image.setImageBitmap(cardItem.image)
        holder.highligth.text = cardItem.highligth

        holder.time.text = cardItem.time
        holder.remote.text = cardItem.remote

        holder.skill1.text = cardItem.skill1
        holder.skill2.text = cardItem.skill2
        holder.skill3.text = cardItem.skill3
        holder.skill4.text = cardItem.skill4
        holder.skill5.text = cardItem.skill5
        holder.skill6.text = cardItem.skill6
        holder.skill7.text = cardItem.skill7
        holder.skill8.text = cardItem.skill8

        if (position > itemCount - 12)
            bottomReachedListener?.onBottomReached(position)
    }

    override fun getItemCount(): Int {
        return cardList_Opportunities.size
    }
}
