package com.example.wallpaperhouse.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperhouse.FinalActivity
import com.example.wallpaperhouse.R
import com.example.wallpaperhouse.model.ColorModel

class ColorAdapter(private val requireContext: Context, val listTheColorTone: ArrayList<ColorModel>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {


    class ColorViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val cardBack = itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(LayoutInflater.from(requireContext).inflate(R.layout.item_colortone,parent,false))
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = listTheColorTone[position].color
       holder.cardBack.setCardBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener {

            val intent = Intent(requireContext, FinalActivity::class.java)

            intent.putExtra("link",listTheColorTone[position].link)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listTheColorTone.size
    }


}