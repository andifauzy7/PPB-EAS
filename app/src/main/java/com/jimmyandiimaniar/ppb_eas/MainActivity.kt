package com.jimmyandiimaniar.ppb_eas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jimmyandiimaniar.ppb_eas.adapter.ListRestaurantAdapter
import com.jimmyandiimaniar.ppb_eas.model.Restaurant
import com.jimmyandiimaniar.ppb_eas.network.HomeDatasource
import com.jimmyandiimaniar.ppb_eas.network.HomeResponse
import com.jimmyandiimaniar.ppb_eas.network.NetworkProvider
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val datasource = NetworkProvider.providesHttpAdapter().create(HomeDatasource::class.java)
        datasource.discoverCities().enqueue(object: Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun showRecyclerCardView() {
        rv_restaurant.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = ListRestaurantAdapter(list)
        rv_restaurant.adapter = cardViewHeroAdapter
    }
}