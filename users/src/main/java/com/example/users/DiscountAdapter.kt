package com.example.users

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DiscountAdapter(private val context: Context,private val discountItemList:ArrayList<DiscountItem>):
RecyclerView.Adapter<DiscountAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(discountItem: DiscountItem) {
            // Bind your data to the view here
            val cardView = itemView.findViewById<CardView>(R.id.cardView)
            val discountName = itemView.findViewById<TextView>(R.id.discountName)
            val discountDescription = itemView.findViewById<TextView>(R.id.discountDescription)
            val discountImage = itemView.findViewById<ImageView>(R.id.discountImage)
            discountName.text = discountItem.getDiscountName()
            discountDescription.text = discountItem.getDiscountDescription()
            discountImage.setImageResource(discountItem.getDiscountImage())
            cardView.setBackgroundResource(discountItem.backgroundColor)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.discount_rv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = position % discountItemList.size
        val discountItem = discountItemList[actualPosition]
        holder.bind(discountItem)
    }
}