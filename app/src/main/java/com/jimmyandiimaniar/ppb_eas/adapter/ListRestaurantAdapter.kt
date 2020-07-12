package com.jimmyandiimaniar.ppb_eas.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jimmyandiimaniar.ppb_eas.R
import com.jimmyandiimaniar.ppb_eas.DetailActivity
import com.jimmyandiimaniar.ppb_eas.model.listRestaurants
import kotlinx.android.synthetic.main.item_row_restaurant.view.*


class ListRestaurantAdapter(private val list: List<listRestaurants>) : RecyclerView.Adapter<ListRestaurantAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(restaurant: listRestaurants) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(restaurant.descRestaurant.thumb)
                    .apply(RequestOptions().override(100, 100))
                    .into(img_item_photo)
                tv_restaurant.text = restaurant.descRestaurant.name
                tv_address.text = restaurant.descRestaurant.location.address
                tv_range.text = restaurant.descRestaurant.average_cost_for_two + " " + restaurant.descRestaurant.currency + " / 2 Orang"
                tv_order_now.text = if(restaurant.descRestaurant.has_online_delivery=="0") {
                    "Belum Bisa Order Online"
                } else {
                    "Menerima Order Sekarang!"
                }
                tv_rating.text = restaurant.descRestaurant.UserRating.aggregate_rating
                itemView.setOnClickListener { v ->
                    val context: Context = v.context
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.ID_RESTAURANT, restaurant.descRestaurant.id)
                    context.startActivity(intent)
                }
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

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(list[holder.adapterPosition])
    }

}