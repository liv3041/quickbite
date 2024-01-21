package com.example.users

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantItemAdapter(private val context: Context,private val restaurantItemList: ArrayList<RestaurantItem>):
RecyclerView.Adapter<RestaurantItemAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantItemAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.restaurant_items_rv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantItemAdapter.ViewHolder, position: Int) {
        val restaurantItem = restaurantItemList[position]
        holder.bind(restaurantItem)
    }

    override fun getItemCount(): Int {
      return restaurantItemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurantItem: RestaurantItem) {
            // Bind your data to the view here
            val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
            val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
            val ratings = itemView.findViewById<TextView>(R.id.ratings)
            val popularFoodItem = itemView.findViewById<TextView>(R.id.popularFoodItem)
            val pricingForOne = itemView.findViewById<TextView>(R.id.pricingForOne)
            val distanceFromUser = itemView.findViewById<TextView>(R.id.distanceFromUser)
            val distanceInKm = itemView.findViewById<TextView>(R.id.distanceInKm)
            restaurantName.text = restaurantItem.getRestaurantName()
            ratings.text = restaurantItem.getRatings()
            popularFoodItem.text = restaurantItem.getPopularFoodItem()
            pricingForOne.text = restaurantItem.getPricing()
            distanceFromUser.text = restaurantItem.getDistanceFromUser()
            distanceInKm.text = restaurantItem.getDistanceInKm()
            restaurantImage.setImageResource(restaurantItem.getRestaurantImage())
        }
    }

}