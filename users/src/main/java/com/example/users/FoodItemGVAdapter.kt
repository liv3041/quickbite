package com.example.users

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodItemGVAdapter(private val context: Context,private val foodItemList: ArrayList<FoodItem>) :
    RecyclerView.Adapter<FoodItemGVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_items_gridview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = position % foodItemList.size
        val foodItem = foodItemList[actualPosition]
        holder.bind(foodItem)

    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foodItem: FoodItem) {
            // Bind your data to the view here
            val foodName = itemView.findViewById<TextView>(R.id.idTVfood)
            val foodImage = itemView.findViewById<ImageView>(R.id.idIVfood)
            foodName.text = foodItem.getFoodName()
            foodImage.setImageResource(foodItem.getFoodImage())
        }
    }
}