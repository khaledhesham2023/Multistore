package com.khaledamin.android.multistore

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.GridView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.slider.Slider
import com.google.firebase.database.*
import kotlin.math.abs


class HomeActivity : AppCompatActivity() {

    lateinit var homeList:GridView
    lateinit var adapter: HomeAdapter
    lateinit var reference: DatabaseReference
    lateinit var list: MutableList<Departments>
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var adList: ArrayList<SlideModel>
    lateinit var adReference: DatabaseReference
   lateinit var imageSlider: ImageSlider
   lateinit var homeMusic: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeList = findViewById(R.id.gridView)
        reference = FirebaseDatabase.getInstance().getReference("departments")
        list = mutableListOf()
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val departments = item.getValue(Departments::class.java)
                        list.add(departments!!)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        adapter = HomeAdapter(this, R.layout.home_item, list)
        homeList.adapter = adapter
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar_home)
        bottomNavigationView.selectedItemId = R.id.main
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.basket -> goToLoginActivity()
                R.id.account -> goToLoginActivity()
                R.id.more -> goToMoreActivity()
                else -> showAMessage()
            }
        }
        adList = ArrayList()
        adReference =FirebaseDatabase.getInstance().getReference("ads")
        adReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                adList.clear()
                if (snapshot.exists()){
                    for (item in snapshot.children){
                        adList.add(SlideModel(item.child("image").getValue().toString()))
                        imageSlider.setImageList(adList,ScaleTypes.FIT)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        imageSlider = findViewById(R.id.sliderView)
        imageSlider.setImageList(adList,ScaleTypes.FIT)

homeMusic = MediaPlayer.create(this,R.raw.homemusic)
        homeMusic.start()
        homeMusic.setOnCompletionListener {
            homeMusic.start()
        }

            }
    private fun showAMessage(): Boolean {
        Log.i(this.toString(),"You are currently in HomeActivity")
        return true
    }

    private fun goToMoreActivity(): Boolean {
var intent:Intent = Intent(this,MoreActivity::class.java)
        startActivity(intent)
        return true
    }

    private fun goToLoginActivity(): Boolean {
        var intent:Intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
return true
    }

    override fun onStop() {
        super.onStop()
        bottomNavigationView.selectedItemId = R.id.main
        homeMusic.stop()
        homeMusic = MediaPlayer.create(this,R.raw.homemusic)
    }

    override fun onResume() {
        super.onResume()
        homeMusic.start()
        homeMusic.setOnCompletionListener {
            homeMusic.start()
        }
    }
        }


