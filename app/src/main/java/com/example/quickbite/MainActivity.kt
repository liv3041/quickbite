package com.example.quickbite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.auth.ScreenActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val deliveryMan: ImageView = findViewById(R.id.delivery_guy)
        val takeAway:ImageView = findViewById(R.id.takeaway)
        val door:ImageView = findViewById(R.id.door)
        val button:MaterialButton = findViewById(R.id.btn_culinary)

        button.setOnClickListener{
            startActivity(Intent(this, ScreenActivity::class.java))
        }

//        delivery man animation
        val animation: Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.move_animation)
        deliveryMan.startAnimation(animation)


//        Door to Takeaway animation
        val handlerAppear = android.os.Handler()
        handlerAppear.postDelayed({
            if (takeAway.visibility==View.GONE){
                takeAway.visibility = View.VISIBLE
                door.visibility = View.GONE
            }
        }, 2000)
    }


}