package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lv=findViewById<ListView>(R.id.listview)
        var data= arrayOf("USA","France","India","Africa")
//        data.add("USA")
//        data.add("France")
//        data.add("England")
//        data.add("Saudi")
//        data.add("India")
//        data.add("Spain")
//        data.add("banana")
        var wc= ArrayAdapter(this,R.layout.mylistview,R.id.textview,data)
        lv.adapter=wc

    }
}