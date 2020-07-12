package com.jimmyandiimaniar.ppb_eas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jimmyandiimaniar.ppb_eas.model.DescRestaurant
import com.jimmyandiimaniar.ppb_eas.model.restaurantFromSearch

class DetailActivity : AppCompatActivity() {
    companion object {
        const val ID_RESTAURANT = "id_restaurant"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_retaurant)
        initiate()

        val data = intent.getParcelableExtra<DescRestaurant>(ID_RESTAURANT)
        if (data != null) {
            val restaurant_name = findViewById<TextView>(R.id.retaurant_name)
            restaurant_name.text = data.name
            val restaurant_image = findViewById<ImageView>(R.id.retaurant_img)
            Glide.with(this)
                .load(data.featured_image)
                .centerCrop()
                .apply(RequestOptions().override(600, 300))
                .into(restaurant_image)
            val retaurant_rating = findViewById<TextView>(R.id.retaurant_rating)
            retaurant_rating.text = data.UserRating.aggregate_rating
            val restaurant_flag = findViewById<TextView>(R.id.restaurant_flag)
            restaurant_flag.text = if(data.has_online_delivery=="0") {
                "Belum Bisa Order Online"
            } else {
                "Menerima Order Sekarang!"
            }
            val retaurant_menu = findViewById<TextView>(R.id.retaurant_menu)
            retaurant_menu.text = data.average_cost_for_two + " / 2 Orang"
            val retaurant_address = findViewById<TextView>(R.id.retaurant_address)
            retaurant_address.text = data.location.address
            val tv_address = findViewById<TextView>(R.id.tv_address)
            tv_address.text = data.UserRating.aggregate_rating
            val id_name2 = findViewById<TextView>(R.id.id_name2)
            id_name2.text = data.UserRating.rating_text

        }


    }

    fun initiate(){
        val img_item_photo = findViewById<ImageView>(R.id.img_item_photo)
        img_item_photo.setImageResource(R.drawable.ic_baseline_supervised_user_circle_24)

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