package com.example.quickbite

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val foodStand: ImageView = findViewById(R.id.food_stand)
        val deliveryMan:ImageView = findViewById(R.id.delivery_man)
        val recyclerView:RecyclerView = findViewById(R.id.featuresOfApp_rv)

//        delivery man animation
        val animation:Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.move_animation)
        deliveryMan.startAnimation(animation)

//        Features of App recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Feature>()
        data.add(Feature(R.drawable.check,"Explore a world of flavors."))
        data.add(Feature(R.drawable.check,"Effortless ordering, just a tap away."))
        data.add(Feature(R.drawable.check,"Lightning-fast delivery for your cravings."))
        data.add(Feature(R.drawable.check,"Personalized recommendations for delight."))
        val adapter = FeaturesAdapter(data)
        recyclerView.adapter = adapter

//        RecyclerView animation

        val layoutAnimation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_fall_down)
        recyclerView.layoutAnimation = layoutAnimation

//          Automatically jumping from one activity to another
        val handler = android.os.Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
        }, 6000)




    }
}