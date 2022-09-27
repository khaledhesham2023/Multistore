package com.khaledamin.android.multistore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.khaledamin.android.multistore.fragments.BakeryFragment
import com.khaledamin.android.multistore.fragments.FruitsFragment
import com.khaledamin.android.multistore.fragments.MeatFragment
import com.khaledamin.android.multistore.fragments.StationaryFragment

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        var viewPager:ViewPager = findViewById(R.id.pager)

        var tabLayout:TabLayout = findViewById(R.id.tab)

        var productStateAdapter:ProductStateAdapter = ProductStateAdapter(supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)






        productStateAdapter.addFragment(StationaryFragment(),"المدارس و الأدوات المكتبية")
        productStateAdapter.addFragment(MeatFragment(),"لحوم و دواجن و أسماك")
        productStateAdapter.addFragment(FruitsFragment(),"خضراوات و فاكهة")
        productStateAdapter.addFragment(BakeryFragment(),"مخبوزات")



        tabLayout.setupWithViewPager(viewPager)

        viewPager.adapter = productStateAdapter





    }


}