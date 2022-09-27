package com.khaledamin.android.multistore

import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.khaledamin.android.multistore.fragments.MeatFragment
import com.khaledamin.android.multistore.fragments.StationaryFragment


class ProductStateAdapter(fm:FragmentManager, behaviour:Int):
    FragmentPagerAdapter(fm,behaviour) {

    private val fragmentsList:ArrayList<Fragment> = arrayListOf()
    private val fragmentsTitlesList:ArrayList<String> = arrayListOf()

    override fun getCount(): Int {
        return fragmentsList.size
    }

    override fun getItem(position: Int): Fragment {
     return fragmentsList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentsTitlesList.get(position)

    }

    fun addFragment(fragment: Fragment,fragmentTitle:String){
        fragmentsList.add(fragment)
        fragmentsTitlesList.add(fragmentTitle)
    }

}