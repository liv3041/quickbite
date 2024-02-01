@file:Suppress("DEPRECATION")

package com.example.users

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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
    private lateinit var search:CardView
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//         Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        changingTextviewInCardSearchBar(view)
        setUpFoodItem(view)
        setUpRestaurantItem(view)
        restaurantItemOnClick(restaurantAdapter)
        setToolBar(view)

        return view

    }

    private fun restaurantItemOnClick(restaurantItemAdapter: RestaurantItemAdapter) {
        restaurantItemAdapter.setItemClickListener(object : RestaurantItemAdapter.OnClickListener {
            override fun onClick(position: Int, model: RestaurantItem) {
                val intent:Intent = Intent(activity,RestaurantDetailsActivity::class.java)
                intent.putExtra("Restaurant Name",model.getRestaurantName())
                intent.putExtra("Restaurant Rating",model.getRatings())
                intent.putExtra("Restaurant Cuisine",model.getPopularFoodItem())
                intent.putExtra("Restaurant Cuisine2",model.getPopularFoodItem2())
                intent.putExtra("Restaurant Price",model.getPricing())
                intent.putExtra("Restaurant Delivery Time",model.getDistanceFromUser())
                intent.putExtra("Restaurant Distance", model.getDistanceInKm())
                startActivity(intent)
            }
        })
    }

    private fun changingTextviewInCardSearchBar(view: View) {
        textViewCard = view.findViewById(R.id.textViewVCard)

        // Start updating the text every 5 seconds
        handler.postDelayed(updateTextRunnable, 5000)

//        Going to SearchView Activity
        search = view.findViewById(R.id.card_search_hf)
        search.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setToolBar(view:View){
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)?:return
        val userPhoto : ImageView = view.findViewById(R.id.profilePhoto)

        (requireActivity() as? AppCompatActivity)?.setSupportActionBar(toolbar)
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.setDisplayUseLogoEnabled(true)
        userPhoto.setOnClickListener {
            val intent = Intent(activity,UserActivity::class.java)
            startActivity(intent)
        }
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
    private fun setUpFoodItem(view:View){
        //        Grid View
        foodItem = view.findViewById(R.id.foodItems_gv)
        foodItem.layoutManager =GridLayoutManager(requireContext(),2,RecyclerView.HORIZONTAL,false)
        foodItemList = ArrayList()



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
    }
    private fun setUpRestaurantItem(view: View) {
        restaurantItem = view.findViewById(R.id.restaurantItems_rv)
        restaurantItemList = ArrayList()
        restaurantItemList.add(RestaurantItem("Burger King",R.drawable.burg,"4.0","Burger","French Fries","100 for one","40-50 min","15.5 km"))
        restaurantItemList.add(RestaurantItem("Burger King",R.drawable.burg,"4.0","Burger","French Fries","100 for one","40-50 min","15.5 km"))
        restaurantItemList.add(RestaurantItem("Burger King",R.drawable.burg,"4.0","Burger","French Fries","100 for one","40-50 min","15.5 km"))
        restaurantItemList.add(RestaurantItem("Burger King",R.drawable.burg,"4.0","Burger","French Fries","100 for one","40-50 min","15.5 km"))
        restaurantItemList.add(RestaurantItem("Burger King",R.drawable.burg,"4.0","Burger","French Fries","100 for one" ,"40-50 min","15.5 km"))
        restaurantItemList.add(RestaurantItem("Burger King",R.drawable.burg,"4.0","Burger","French Fries","100 for one","40-50 min","15.5 km"))

        restaurantAdapter = RestaurantItemAdapter(requireContext(),restaurantItemList)
        restaurantItem.isNestedScrollingEnabled = false
        restaurantItem.setHasFixedSize(false)
        parentScrollView = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        restaurantItem.layoutManager = parentScrollView
        restaurantItem.adapter = restaurantAdapter
    }



}