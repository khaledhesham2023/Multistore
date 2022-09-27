package com.khaledamin.android.multistore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso

class SliderAdapter internal constructor(list:MutableList<AdItem>,viewPager2: ViewPager2)
    : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private val sliderList:List<AdItem>

    init {
        this.sliderList = list
    }

    class SliderViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val image:ImageView = itemView.findViewById(R.id.ad_image)

        fun image(adItem: AdItem){

            Picasso.get().load(adItem.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.ad_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.image(sliderList[position])
    }

    override fun getItemCount(): Int {
        return sliderList.size
    }
}