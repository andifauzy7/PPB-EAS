package com.jimmyandiimaniar.ppb_eas

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_retaurant)

        val restaurant_name = findViewById<TextView>(R.id.retaurant_name)
        restaurant_name.text = "Paskal Food Court"
        val restaurant_image = findViewById<ImageView>(R.id.retaurant_img)
        Glide.with(this)
            .load("https://d.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4dbb79dd7c8091b30c642077_featured_v2.png")
            .centerCrop()
            .apply(RequestOptions().override(600, 300))
            .into(restaurant_image)

        val restaurant_rating_icon = findViewById<ImageView>(R.id.restaurant_rating_icon)
        restaurant_rating_icon.setImageResource(R.drawable.ic_baseline_star_24)

        val restaurant_flag = findViewById<ImageView>(R.id.restaurant_flag_icon)
        restaurant_flag.setImageResource(R.drawable.ic_baseline_outlined_flag_24)

        val retaurant_menu_icon = findViewById<ImageView>(R.id.retaurant_menu_icon)
        retaurant_menu_icon.setImageResource(R.drawable.ic_baseline_restaurant_menu_24)

        val restaurant_location_icon = findViewById<ImageView>(R.id.restaurant_location_icon)
        restaurant_location_icon.setImageResource(R.drawable.ic_baseline_location_on_24)
    }
}