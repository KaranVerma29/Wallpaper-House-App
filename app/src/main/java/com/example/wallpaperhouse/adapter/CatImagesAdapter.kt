package com.example.wallpaperhouse.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperhouse.CatActivity
import com.example.wallpaperhouse.FinalActivity
import com.example.wallpaperhouse.model.BomModel
import com.example.wallpaperhouse.R
import com.makeramen.roundedimageview.RoundedImageView

class CatImagesAdapter(private val requireContext: Context, private val listBestOfTheMonth: ArrayList<BomModel>) : RecyclerView.Adapter<CatImagesAdapter.bomViewHolder>() {

    class bomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         val imageView = itemView.findViewById<RoundedImageView>(R.id.catImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_wallpaper,parent,false))
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBestOfTheMonth[position].link).into(holder.imageView)

        holder.itemView.setOnClickListener {

            val intent = Intent(requireContext,FinalActivity::class.java)

            intent.putExtra("link",listBestOfTheMonth[position].link)

            requireContext.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return listBestOfTheMonth.size
    }
}