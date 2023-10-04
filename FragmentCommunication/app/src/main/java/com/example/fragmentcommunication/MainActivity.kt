package com.example.fragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(),FirstFragment.FirstFragmentListener {
    var frag1:Fragment?=null
    var frag2:Fragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         var manager=supportFragmentManager
         frag1=FirstFragment()
         frag2=SecondFragment()

        manager.beginTransaction().replace(R.id.linearLayout1, frag1 as FirstFragment).replace(R.id.linearLayout2,
            frag2 as SecondFragment
        ).commit()

    }

    override fun sendDataToSecond(data: String) {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.linearLayout2) as? SecondFragment
        fragment?.updateData(data)
    }
}
