package com.example.wallpaperhouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wallpaperhouse.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {
    lateinit var binding: ActivityFinalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("link")



        Glide.with(this).load(url).into( binding.finalWallpaper)

        binding.btnSave.setOnClickListener {


        }
        binding.btnSet.setOnClickListener {


        }

    }
}