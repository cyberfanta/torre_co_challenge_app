package com.cyberfanta.torre_co_challenge_app.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter_Peoples.CardViewHolder
import java.util.*

class CardAdapter_Peoples(private val cardList_Peoples: ArrayList<CardItem_Peoples>) : RecyclerView.Adapter<CardViewHolder>() {
    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name_people: TextView
        var image_people: ImageView
        var highligth_people: TextView
        var time1: TextView
        var time2: TextView
        var time3: TextView
        var time4: TextView
        var skill1_people: TextView
        var skill2_people: TextView
        var skill3_people: TextView
        var skill4_people: TextView
        var skill5_people: TextView
        var skill6_people: TextView
        var skill7_people: TextView
        var skill8_people: TextView

        init {
            image_people = itemView.findViewById(R.id.image_people)
            name_people = itemView.findViewById(R.id.name_people)
            highligth_people = itemView.findViewById(R.id.highligth_people)
            time1 = itemView.findViewById(R.id.time1)
            time2 = itemView.findViewById(R.id.time2)
            time3 = itemView.findViewById(R.id.time3)
            time4 = itemView.findViewById(R.id.time4)
            skill1_people = itemView.findViewById(R.id.skill1_people)
            skill2_people = itemView.findViewById(R.id.skill2_people)
            skill3_people = itemView.findViewById(R.id.skill3_people)
            skill4_people = itemView.findViewById(R.id.skill4_people)
            skill5_people = itemView.findViewById(R.id.skill5_people)
            skill6_people = itemView.findViewById(R.id.skill6_people)
            skill7_people = itemView.findViewById(R.id.skill7_people)
            skill8_people = itemView.findViewById(R.id.skill8_people)
        }
    }

    /**
     * Called when RecyclerView needs a new [CardViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_peoples, parent, false)
        return CardViewHolder(view)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [CardViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike , RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [CardViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardList_Peoples[position]
        holder.image_people.setImageBitmap(cardItem.image)
        holder.name_people.text = cardItem.name
        holder.highligth_people.text = cardItem.highligth
        holder.time1.text = cardItem.time1
        holder.time2.text = cardItem.time2
        holder.time3.text = cardItem.time3
        holder.time4.text = cardItem.time4
        holder.skill1_people.text = cardItem.skill1
        holder.skill2_people.text = cardItem.skill2
        holder.skill3_people.text = cardItem.skill3
        holder.skill4_people.text = cardItem.skill4
        holder.skill5_people.text = cardItem.skill5
        holder.skill6_people.text = cardItem.skill6
        holder.skill7_people.text = cardItem.skill7
        holder.skill8_people.text = cardItem.skill8
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return cardList_Peoples.size
    }
}