package com.example.connectionnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var networkConectivity: NetworkConectivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tv)
        networkConectivity = NetworkConectivity(application)
        networkConectivity.observe(this, Observer {
            when (it) {
                true -> tv.text = "Connected"
                false -> tv.text = "Not Connected"
            }
        })
    }
}