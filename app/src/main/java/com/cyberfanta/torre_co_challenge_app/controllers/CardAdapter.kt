package com.cyberfanta.torre_co_challenge_app.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.torre_co_challenge_app.R
import com.cyberfanta.torre_co_challenge_app.controllers.CardAdapter.CardViewHolder
import java.util.*

class CardAdapter(private val cardList: ArrayList<CardItem>) : RecyclerView.Adapter<CardViewHolder>() {
    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var name: TextView
        var highligth: TextView
        var time: TextView
        var remote: TextView
        var skill1: TextView
        var skill2: TextView
        var skill3: TextView
        var skill4: TextView
        var skill5: TextView
        var skill6: TextView
        var skill7: TextView
        var skill8: TextView

        init {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.name)
            highligth = itemView.findViewById(R.id.highligth)
            time = itemView.findViewById(R.id.time)
            remote = itemView.findViewById(R.id.remote)
            skill1 = itemView.findViewById(R.id.skill1)
            skill2 = itemView.findViewById(R.id.skill2)
            skill3 = itemView.findViewById(R.id.skill3)
            skill4 = itemView.findViewById(R.id.skill4)
            skill5 = itemView.findViewById(R.id.skill5)
            skill6 = itemView.findViewById(R.id.skill6)
            skill7 = itemView.findViewById(R.id.skill7)
            skill8 = itemView.findViewById(R.id.skill8)
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
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
        val cardItem = cardList[position]
        holder.image.setImageBitmap(cardItem.getImage())
        holder.name.text = cardItem.getName()
        holder.highligth.text = cardItem.getHighligth()
        holder.time.text = cardItem.getTime()
        holder.remote.text = cardItem.getRemote()
        holder.skill1.text = cardItem.getSkill1()
        holder.skill2.text = cardItem.getSkill2()
        holder.skill3.text = cardItem.getSkill3()
        holder.skill4.text = cardItem.getSkill4()
        holder.skill5.text = cardItem.getSkill5()
        holder.skill6.text = cardItem.getSkill6()
        holder.skill7.text = cardItem.getSkill7()
        holder.skill8.text = cardItem.getSkill8()
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return cardList.size
    }
}