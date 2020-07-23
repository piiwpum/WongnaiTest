package com.piiwpum.wongnaitest.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.piiwpum.wongnaitest.model.Coin
import com.piiwpum.wongnaitest.R
import com.squareup.picasso.Picasso

class CoinAdapter constructor(
    private val context: Context?,
    private val coinLs: MutableList<Coin>
) :
    RecyclerView.Adapter<CoinAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_item_coin, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = coinLs.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coin = coinLs.get(position)
        holder.tvName.text = "${coin.name}"
        holder.tvDescription.text = "${coin.description}"
        Log.d("coinURL", coin.iconUrl)
        Picasso.get().load(coin.iconUrl).resize(50, 50).into(holder.imageView)
    }


}