package com.jimmyandiimaniar.ppb_eas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jimmyandiimaniar.ppb_eas.adapter.ListRestaurantAdapter
import com.jimmyandiimaniar.ppb_eas.model.Restaurant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Restaurant>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var restaurant = Restaurant("Paskal Food Market", "https://b.zmtcdn.com/data/res_imagery/18387851_RESTAURANT_956761a6f47856c16a0fbc4593ad73aa.jpg",
            "Paskal Hyper Square, Jl. Pasir Kaliki No.25-27, Kb. Jeruk, Kec. Andir, Kota Bandung, Jawa Barat 40181",
            200000, "IDR", "4",1)
        list.add(restaurant)
        rv_restaurant.setHasFixedSize(true)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rv_restaurant.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = ListRestaurantAdapter(list)
        rv_restaurant.adapter = cardViewHeroAdapter
    }
}