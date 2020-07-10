package com.jimmyandiimaniar.ppb_eas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jimmyandiimaniar.ppb_eas.R
import com.jimmyandiimaniar.ppb_eas.model.Restaurant
import kotlinx.android.synthetic.main.item_row_restaurant.view.*

class ListRestaurantAdapter(private val listRestaurant: ArrayList<Restaurant>) : RecyclerView.Adapter<ListRestaurantAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: Restaurant) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(restaurant.avatar)
                    .apply(RequestOptions().override(100, 100))
                    .into(img_item_photo)
                tv_restaurant.text = restaurant.name
                tv_address.text = restaurant.address
                tv_range.text = restaurant.averageCost.toString() + " " + restaurant.concurrency
                tv_order_now.text = restaurant.onlineDelivery.toString()
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListRestaurantAdapter.CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_restaurant, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int = listRestaurant.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listRestaurant[position])
    }

}