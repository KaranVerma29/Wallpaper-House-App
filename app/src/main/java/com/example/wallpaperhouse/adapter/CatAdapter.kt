package com.example.wallpaperhouse.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperhouse.CatActivity
import com.example.wallpaperhouse.R
import com.example.wallpaperhouse.model.CatModel

class CatAdapter(private val requireContext: Context, val listOfTheCategory: ArrayList<CatModel>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    class CatViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.cat_image)
        val name = itemView.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_category,parent,false))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.name.text = listOfTheCategory[position].name
        Glide.with(requireContext).load(listOfTheCategory[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {

            val intent = Intent(requireContext,CatActivity::class.java)
            intent.putExtra("uid",listOfTheCategory[position].id)
            intent.putExtra("name",listOfTheCategory[position].name)

            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listOfTheCategory.size
    }
}