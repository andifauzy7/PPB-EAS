package com.jimmyandiimaniar.ppb_eas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_retaurant)

        val restaurant_name = findViewById<TextView>(R.id.retaurant_name)
        restaurant_name.text = "Paskal Food Court"
    }
}