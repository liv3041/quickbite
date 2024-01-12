package com.example.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        //      transparent status bar
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,R.color.transparent100)


        val apple:ImageView = findViewById(R.id.appleGuitar)
        val signUp:AppCompatButton = findViewById(R.id.btn_signIn)
        val login:AppCompatButton = findViewById(R.id.btn_signUp)
        login.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
}