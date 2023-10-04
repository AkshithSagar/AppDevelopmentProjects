package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pager: ViewPager2 = findViewById(R.id.viewPager2)
        val adapter=ViewPageAdapter(this)
        pager.adapter=adapter

    }
    class ViewPageAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
return 3
        }

        override fun createFragment(position: Int): Fragment {
            val fragment:Fragment=
            when(position){
                1-> return redfragment()
                2-> return bluefragment()
                3-> return greenfragment()
                else-> return bluefragment()

            }
        }

        private fun greenfragment(): Fragment {
        return greenfragment()
        }

        private fun bluefragment(): Fragment {
        return bluefragment()
        }

        private fun redfragment(): Fragment {
            return redfragment()
        }
    }
}