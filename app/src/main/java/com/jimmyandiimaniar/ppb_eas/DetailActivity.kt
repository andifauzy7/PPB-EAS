package com.jimmyandiimaniar.ppb_eas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.location.FusedLocationProviderClient
import com.jimmyandiimaniar.ppb_eas.model.DescRestaurant
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.constants.Style
import com.mapbox.mapboxsdk.maps.MapView

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

        Mapbox.getInstance(this, "pk.eyJ1IjoiYW5kaWZhdXp5NyIsImEiOiJja2Npa2o4Y2Uwa3ZhMnRvZTY4YjUwOTBuIn0.V2U0Cys-qY9IIoSCVFHu4g")
        val mapView = findViewById(R.id.mapView) as MapView
        mapView.setStyleUrl(Style.MAPBOX_STREETS)
        mapView.onCreate(savedInstanceState)
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