package com.example.users

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FiltersAdapter(private var context: Context , private var filtersItemList:ArrayList<FiltersItem>):
    RecyclerView.Adapter<FiltersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(filtersItem: FiltersItem) {
            // Bind your data to the view here
            val filtersName = itemView.findViewById<TextView>(R.id.filtersName)
            val filtersLeftImage = itemView.findViewById<ImageView>(R.id.filtersLeftImage)
            val filtersRightImage = itemView.findViewById<ImageView>(R.id.filtersRightImage)
            filtersName.text = filtersItem.getFilterName()
            filtersLeftImage.setImageResource(filtersItem.getFilterLeftImage())
            filtersRightImage.setImageResource(filtersItem.getFilterRightImage())
            if(filtersItem.getFilterRightImage() == R.drawable.down_filled_triangular_arrow){
                filtersRightImage.visibility = View.VISIBLE
            }else{
                filtersRightImage.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.filters_rv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  filtersItemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filtersItem = filtersItemList[position]
        holder.bind(filtersItem)
    }
}