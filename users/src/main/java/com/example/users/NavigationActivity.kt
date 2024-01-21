package com.example.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        var NavController :NavController = findNavController(R.id.fragmentContainerView)
        var bottomNavigationView:BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.setupWithNavController(NavController)
    }
}