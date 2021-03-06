package com.jimmyandiimaniar.ppb_eas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.jimmyandiimaniar.ppb_eas.adapter.ListRestaurantAdapter
import com.jimmyandiimaniar.ppb_eas.network.HomeDatasource
import com.jimmyandiimaniar.ppb_eas.model.restaurantFromSearch
import com.jimmyandiimaniar.ppb_eas.network.NetworkProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.pb_home)

        val datasource = NetworkProvider.providesHttpAdapter().create(HomeDatasource::class.java)
        datasource.discoverRestaurantFromSearch().enqueue(object : Callback<restaurantFromSearch> {
            override fun onResponse(call: Call<restaurantFromSearch>, response: Response<restaurantFromSearch>) {
                progressBar.visibility = View.GONE
                val results = response.body()?.cities
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_restaurant)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = ListRestaurantAdapter(results ?: emptyList())
            }

            override fun onFailure(call: Call<restaurantFromSearch>, t: Throwable) {
                Log.e(MainActivity::class.java.simpleName, "${t.printStackTrace()}")
            }
        })

    }
}