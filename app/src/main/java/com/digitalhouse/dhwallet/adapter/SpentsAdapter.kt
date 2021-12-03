package com.digitalhouse.dhwallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Spents

class SpentsAdapter(private val items: List<Spents>) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)

            return SpentsViewHolder(inflater.inflate(R.layout.item_spent, parent, false))

        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is SpentsViewHolder -> holder.bind(items[position])
            }

        }

        override fun getItemCount() = items.size
    }

    class SpentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val image: ImageView = view.findViewById(R.id.image_transaction)
        private val title: TextView = view.findViewById(R.id.item_spents_title)
        private val subtitle: TextView = view.findViewById(R.id.item_spents_subtitle)
        private val money: TextView = view.findViewById(R.id.item_spent_money)

        fun bind(item: Spents) {
            Glide.with(image.context).load(item.image).circleCrop().into(image)
            title.text = item.name
            subtitle.text = item.type.description
            money.text = item.money


        }

}