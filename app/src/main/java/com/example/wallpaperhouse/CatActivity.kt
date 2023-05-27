package com.example.wallpaperhouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpaperhouse.adapter.CatImagesAdapter
import com.example.wallpaperhouse.databinding.ActivityCatBinding
import com.example.wallpaperhouse.model.BomModel
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name = intent.getStringExtra("name")

        db.collection("categories").document(uid!!).collection("wallpaper").
        addSnapshotListener { value, error ->

            binding.catTitle.text = name.toString()

           // binding.catCount.text = listOfCatWallpaper.size.toString()


            val listOfCatWallpaper = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listOfCatWallpaper.addAll(data!!)

            binding.catRcv.layoutManager =StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
            binding.catRcv.adapter = CatImagesAdapter(this,listOfCatWallpaper)

        }

    }
}