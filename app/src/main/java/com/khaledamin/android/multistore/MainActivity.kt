package com.khaledamin.android.multistore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    // Timer setup
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up the timer required until data is loaded completely in {@link HomeActivity}
        timer = Timer()
        timer.schedule(timerTask {
            intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
        },5000)

    }
}