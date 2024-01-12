package com.example.quickbite

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class FeaturesAdapter(private val list: List<Feature>) : RecyclerView.Adapter<FeaturesAdapter.ViewHolder>(){

class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val imageView:ImageView = itemView.findViewById(R.id.check)
    val textView:TextView = itemView.findViewById(R.id.text)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_features_of_app,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = list[position]
        holder.imageView.setImageResource(itemsViewModel.checkImage)
        holder.textView.text = itemsViewModel.featureName
    }
}