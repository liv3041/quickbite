@file:Suppress("DEPRECATION")

package com.example.users

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var textViewCard: TextView
    private lateinit var foodItem:RecyclerView
    private lateinit var foodItemList:ArrayList<FoodItem>
    private lateinit var gridViewAdapter : FoodItemGVAdapter
    private lateinit var restaurantItem:RecyclerView
    private lateinit var restaurantItemList:ArrayList<RestaurantItem>
    private lateinit var restaurantAdapter:RestaurantItemAdapter
    private lateinit var parentScrollView:LinearLayoutManager
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//         Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        textViewCard = view.findViewById(R.id.textViewCard)

        // Start updating the text every 5 seconds
        handler.postDelayed(updateTextRunnable, 5000)


//        Grid View
        foodItem = view.findViewById(R.id.foodItems_gv)
        foodItem.layoutManager =GridLayoutManager(requireContext(),2,RecyclerView.HORIZONTAL,false)
        foodItemList = ArrayList()

        restaurantItem = view.findViewById(R.id.restaurantItems_rv)

        foodItemList.add(FoodItem("Sweets",R.drawable.kaju))
        foodItemList.add(FoodItem("Chicken",R.drawable.chicken))

        foodItemList.add(FoodItem("Panner",R.drawable.panner))
        foodItemList.add(FoodItem("Coffee",R.drawable.coffee))
        foodItemList.add(FoodItem("Pizza",R.drawable.pizza))
        foodItemList.add(FoodItem("Cake",R.drawable.cake))
        foodItemList.add(FoodItem("Chaat",R.drawable.chat))
        foodItemList.add(FoodItem("Dosa",R.drawable.dosa))
        foodItemList.add(FoodItem("Chowmien",R.drawable.chowmien))
        foodItemList.add(FoodItem("Momos",R.drawable.momos))
        foodItemList.add(FoodItem("Shakes",R.drawable.shake))
        foodItemList.add(FoodItem("Burger",R.drawable.burger))
        foodItemList.add(FoodItem("Pie",R.drawable.pie))
        foodItemList.add(FoodItem("Muffins",R.drawable.muffins))
        gridViewAdapter= FoodItemGVAdapter(requireContext(), foodItemList)
        foodItem.adapter = gridViewAdapter


        restaurantItemList = ArrayList()
        restaurantItemList.add(RestaurantItem("",R.drawable.burger,"","","","",""))
        restaurantItemList.add(RestaurantItem("",R.drawable.burger,"","","","",""))
        restaurantItemList.add(RestaurantItem("",R.drawable.burger,"","","","",""))
        restaurantItemList.add(RestaurantItem("",R.drawable.burger,"","","","",""))
        restaurantItemList.add(RestaurantItem("",R.drawable.burger,"","","","",""))


        restaurantAdapter = RestaurantItemAdapter(requireContext(),restaurantItemList)
        restaurantItem.isNestedScrollingEnabled = false
        restaurantItem.setHasFixedSize(false)
        parentScrollView = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        restaurantItem.layoutManager = parentScrollView
        restaurantItem.adapter = restaurantAdapter
        return view

    }
    private val updateTextRunnable = object : Runnable {
        override fun run() {
            // Update the text based on your logic
            val newText = if (textViewCard.text == "Search Here 'Burger' ") {
                "Search Here 'Pizza' "
            } else {
                "Search Here 'Burger' "
            }

            // Set the new text
            textViewCard.text = newText

            // Schedule the next update after 5 seconds
            handler.postDelayed(this, 5000)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        // Remove the callback to prevent memory leaks
        handler.removeCallbacks(updateTextRunnable)
    }



}