package com.example.wallpaperhouse.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaperhouse.model.BomModel
import com.example.wallpaperhouse.adapter.BomAdapter
import com.example.wallpaperhouse.adapter.CatAdapter
import com.example.wallpaperhouse.adapter.ColorAdapter
import com.example.wallpaperhouse.databinding.FragmentHomeBinding
import com.example.wallpaperhouse.model.CatModel
import com.example.wallpaperhouse.model.ColorModel
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

     private lateinit var binding: FragmentHomeBinding
     private lateinit var db :FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        db= FirebaseFirestore.getInstance()

        db.collection("bestofmonth").addSnapshotListener { value, error ->
            val listBestOfTheMonth = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listBestOfTheMonth.addAll(data!!)
            binding.rcvBom.layoutManager= LinearLayoutManager(
                requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.rcvBom.adapter = BomAdapter(requireContext(),listBestOfTheMonth)

        }
         db.collection("colortone").addSnapshotListener { value, error ->
             val listTheColorTone = arrayListOf<ColorModel>()
             val data = value?.toObjects(ColorModel::class.java)
             listTheColorTone.addAll(data!!)

             binding.rcvTcw.layoutManager = LinearLayoutManager(
                 requireContext(),LinearLayoutManager.HORIZONTAL,false)
             binding.rcvTcw.adapter = ColorAdapter(requireContext(),listTheColorTone)

         }
          db.collection("categories").addSnapshotListener { value, error ->
              val listOfTheCategory = arrayListOf<CatModel>()
              val data = value?.toObjects(CatModel::class.java)
              listOfTheCategory.addAll(data!!)

              binding.rcvCategory.layoutManager = GridLayoutManager(requireContext(),2)
              binding.rcvCategory.adapter = CatAdapter(requireContext(),listOfTheCategory)
          }
         return binding.root


    }







    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}