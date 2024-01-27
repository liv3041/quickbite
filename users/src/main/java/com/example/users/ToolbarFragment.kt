package com.example.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout


class ToolbarFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_toolbar, container, false)
        val profilePicture:ImageView = view.findViewById(R.id.profilePhotoT)
        val downArrow:ImageView = view.findViewById(R.id.down_arrow)
        val area:TextView = view.findViewById(R.id.area)
        val locale:TextView = view.findViewById(R.id.locale)
        val location:ImageView = view.findViewById(R.id.location)

        area.text = "Your Area"
        locale.text = "Your Locale"

        (activity as AppCompatActivity).supportActionBar?.title = "Your Title"


        return view
    }

}