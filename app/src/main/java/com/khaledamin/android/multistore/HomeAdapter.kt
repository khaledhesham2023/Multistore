package com.khaledamin.android.multistore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class HomeAdapter(context: Context,val resId:Int,val list: List<Departments>)
    : ArrayAdapter<Departments>(context,resId,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var departments:Departments = list[position]
        val view:View = LayoutInflater.from(context).inflate(resId,parent,false)
        var name:TextView = view.findViewById(R.id.name)
        var image:ImageView = view.findViewById(R.id.image)
        name.text = departments.name
        Picasso.get().load(departments.image).into(image)
return view
    }
}