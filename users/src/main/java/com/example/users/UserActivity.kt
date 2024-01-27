package com.example.users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class UserActivity : AppCompatActivity() {

     private lateinit var backButton:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
         setBackButton()
        }
    private fun setBackButton(){
         backButton=findViewById(R.id.back_btn_ua)
         backButton.setOnClickListener{
            val intent = Intent(this@UserActivity,NavigationActivity::class.java)
            startActivity(intent)
        }

    }

}