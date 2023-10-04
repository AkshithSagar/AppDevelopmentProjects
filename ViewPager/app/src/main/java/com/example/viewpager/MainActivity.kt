package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewPager: ViewPager = findViewById(R.id.viewPager2)
        var myPagerAdapter:MyPagerAdapter = MyPagerAdapter(this)
        viewPager.adapter = myPagerAdapter
    }
}