package com.example.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class RestaurantDetailsActivity : AppCompatActivity() {
    private lateinit var rName:TextView
    private lateinit var discountItem: RecyclerView
    private lateinit var discountAdapter: DiscountAdapter
    private lateinit var discountItemList:ArrayList<DiscountItem>
    private lateinit var layoutManagerD:LinearLayoutManager
    private lateinit var handler: Handler
    private lateinit var autoScrollRunnable: Runnable
    private var scrollPosition = 0

    private  lateinit var filtersItem: RecyclerView
    private lateinit var filtersAdapter: FiltersAdapter
    private lateinit var filtersItemList:ArrayList<FiltersItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)
        retrieveDataFromIntent()
        discount()
        discountAutoScroll()
        filters()


    }

    private fun filters() {
        filtersItem = findViewById(R.id.filtersItem_rv)
        layoutManagerD = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        filtersItemList = ArrayList()
        filtersItem.layoutManager = layoutManagerD
        filtersItemList.add(FiltersItem(R.drawable.filter,"Filters",R.drawable.down_filled_triangular_arrow))
        filtersItemList.add(FiltersItem(R.drawable.veg_logo_png,"Veg",0))
        filtersItemList.add(FiltersItem(R.drawable.non_veg_logo,"Non-veg",0))
        filtersItemList.add(FiltersItem(R.drawable.boiled_egg,"Egg",0))
        filtersItemList.add(FiltersItem(R.drawable.premium_quality,"Bestseller",0))
        filtersItemList.add(FiltersItem(R.drawable.medal,"Top rated",0))
        filtersItemList.add(FiltersItem(R.drawable.pepper,"Spicy",0))
        filtersAdapter= FiltersAdapter(this,filtersItemList)
        filtersItem.adapter = filtersAdapter

    }

    private fun discountAutoScroll() {
        handler = Handler(Looper.getMainLooper())
        autoScrollRunnable = object : Runnable {
            override fun run() {
                if (scrollPosition < discountItemList.size - 1) {
                    scrollPosition++
                } else {
                    scrollPosition = 0
                }
                discountItem.smoothScrollToPosition(scrollPosition)
                handler.postDelayed(this, AUTO_SCROLL_INTERVAL)
            }
        }



        // Start auto-scrolling when the activity is created
        handler.postDelayed(autoScrollRunnable, AUTO_SCROLL_INTERVAL)
    }

    private fun discount() {
        discountItem = findViewById(R.id.discountItem_rv)
        layoutManagerD = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        discountItemList = ArrayList()
        discountItem.layoutManager = layoutManagerD

        discountItemList.add(DiscountItem(R.drawable.discount_colo,"FLAT ₹100 OFF","Use code GET100 | above ₹549",R.drawable.discount_bg_color))
        discountItemList.add(DiscountItem(R.drawable.discount_colo,"20% OFF up to ₹50","Use code CRAVINGS | above ₹129",R.drawable.discount_bg_color))
        discountItemList.add(DiscountItem(R.drawable.food_delivery_qb,"Free Delivery","above ₹1500",R.drawable.discount_bg_color))
        discountAdapter= DiscountAdapter(this, discountItemList)
        discountItem.adapter = discountAdapter

//        val radius:Int = resources.getDimensionPixelSize(R.dimen.dots_radius)
//        val dotsHeight:Int = resources.getDimensionPixelSize(R.dimen.dots_height)
//        val color:Int = ContextCompat.getColor(this, R.color.medium_gray)
//        discountItem.addItemDecoration(DotsIndicatorDecoration(this,radius,radius*4,dotsHeight,color,color))
//        PagerSnapHelper().attachToRecyclerView(discountItem)

    }

    private fun retrieveDataFromIntent() {

        rName = findViewById(R.id.restaurantName_rd)


        // Retrieve data from Intent
        val restaurantName = intent.getStringExtra("Restaurant Name")
        val restaurantRating = intent.getStringExtra("Restaurant Rating")
        val restaurantCuisine = intent.getStringExtra("Restaurant Cuisine")
        val restaurantCuisine2 = intent.getStringExtra("Restaurant Cuisine2")
        val restaurantPrice = intent.getStringExtra("Restaurant Price")
        val restaurantDeliveryTime = intent.getStringExtra("Restaurant Delivery Time")
        val restaurantDistance = intent.getStringExtra("Restaurant Distance")

        if (restaurantName != null) {
            rName.text = restaurantName
        } else {
            // Log a message or handle the case where the data is null
            Log.e("RestaurantDetailsActivity", "RestaurantName is null")
        }


    }
    override fun onDestroy() {
        // Stop the auto-scrolling when the activity is destroyed to prevent memory leaks
        handler.removeCallbacks(autoScrollRunnable)
        super.onDestroy()
    }

    // ... (other methods)

    companion object {
        private const val AUTO_SCROLL_INTERVAL = 3000L // Interval in milliseconds between each scroll
    }
}