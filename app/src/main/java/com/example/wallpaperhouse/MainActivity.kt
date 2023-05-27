package com.example.wallpaperhouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.wallpaperhouse.databinding.ActivityMainBinding
import com.example.wallpaperhouse.fragment.DownloadFragment
import com.example.wallpaperhouse.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.icHome.setOnClickListener {
          replaceFragment(HomeFragment.newInstance())

       }

       binding.icDownload.setOnClickListener {
           replaceFragment(DownloadFragment.newInstance())

       }


    }
    private fun replaceFragment(newInstance:Fragment){
       val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()

    }
}