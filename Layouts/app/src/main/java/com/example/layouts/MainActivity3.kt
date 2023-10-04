package com.example.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var i=intent
        var str=i.getStringExtra("pora").toString()
        Toast.makeText(this, "Po ra="+str, Toast.LENGTH_SHORT).show()

    }
}