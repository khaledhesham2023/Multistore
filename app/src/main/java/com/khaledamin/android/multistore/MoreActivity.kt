package com.khaledamin.android.multistore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoreActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        val list: ArrayList<More> =
            arrayListOf(
                More(R.drawable.ic_baseline_info_24, "عن التطبيق"),
                More(R.drawable.ic_baseline_360_24, "سياسة الاسترجاع و الاستبدال"),
                More(R.drawable.ic_baseline_help_24, "الشروط و الأحكام"),
                More(R.drawable.ic_baseline_help_24, "سياسة الاستخدام")
            )

        val moreAbout: ListView = findViewById(R.id.list)
        val adapter:MoreAdapter = MoreAdapter(this,list)
        moreAbout.adapter = adapter

        bottomNavigationView = findViewById(R.id.bottom_navigation_bar_more)
        bottomNavigationView.selectedItemId = R.id.more
        bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId){
                R.id.main -> goToHomeActivity()
                R.id.basket -> goToLoginActivity()
                R.id.account -> goToLoginActivity()
                else -> showAMessage()
            }
        }
    }


    private fun showAMessage(): Boolean {
        return true

    }


    private fun goToHomeActivity(): Boolean {

        val intent: Intent = Intent(this@MoreActivity,HomeActivity::class.java)
        startActivity(intent)
        return true
    }

    private fun goToLoginActivity(): Boolean {

        val intent: Intent = Intent(this@MoreActivity,LoginActivity::class.java)
        startActivity(intent)
        return true
    }


}


class MoreAdapter(context: Context, list: ArrayList<More>)
    : ArrayAdapter<More>(context,R.layout.more_item,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val more: More? = getItem(position)
        val convertView = LayoutInflater.from(context).inflate(R.layout.more_item, parent, false)
        val iconText: TextView = convertView.findViewById(R.id.iconText)
        val iconImage: ImageView = convertView.findViewById(R.id.iconImage)
        iconText.text = more?.text
        iconImage.setImageResource(more!!.icon)

        return convertView


    }
}


