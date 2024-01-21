package com.example.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ViewFlipper
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.users.NavigationActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonLogin : MaterialButton = findViewById(R.id.btn_login)


        buttonLogin.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
        //      transparent status bar
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,R.color.transparent100)

        val flipper:ViewFlipper = findViewById(R.id.viewFlipper)
        flipper.setInAnimation(this,R.anim.slide_right)
        flipper.setOutAnimation(this,R.anim.slide_left)
        flipper.flipInterval = 2000
        flipper.startFlipping()

        val buttonOthers:AppCompatButton = findViewById(R.id.btn_others)
        buttonOthers.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog,null)
            val btnFacebook = view.findViewById<AppCompatButton>(R.id.btn_facebook)
            val  btnPhone = view.findViewById<AppCompatButton>(R.id.btn_phone)
            val floatingButton = view.findViewById<CardView>(R.id.cardview)
            floatingButton.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}