package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val moviearray= arrayListOf<Movie>()
        initData(moviearray)
        val recycler=findViewById<RecyclerView>(R.id.recyclerview)
        val adapt=MovieAdapter(this, moviearray)
        recycler.adapter=adapt

        recycler.layoutManager=GridLayoutManager(this,2)
    }

    private fun initData(MovieArr:ArrayList<Movie>) {
        val red=Movie("Red","Shanks",R.drawable.red)
        val gold=Movie("Gold","Luffy",R.drawable.gold)
        val stampede=Movie("Stampede","Worst_Gen",R.drawable.stampede)
        val timeskip=Movie("Timeskip","Monkey D Luffy",R.drawable.timeskip)
        val strongworld=Movie("Strongworld","Shiki",R.drawable.strongworld)
        val z=Movie("Z","Z",R.drawable.z)
        val red1=Movie("Red","Shanks",R.drawable.red)
        val gold1=Movie("Gold","Luffy",R.drawable.gold)
        val stampede1=Movie("Stampede","Worst_Gen",R.drawable.stampede)
        val timeskip1=Movie("Timeskip","Monkey D Luffy",R.drawable.timeskip)
        val strongworld1=Movie("Strongworld","Shiki",R.drawable.strongworld)
        val z1=Movie("Z","Z",R.drawable.z)

        MovieArr.add(red)
        MovieArr.add(gold)
        MovieArr.add(stampede)
        MovieArr.add(timeskip)
        MovieArr.add(strongworld)
        MovieArr.add(z)
        MovieArr.add(red1)
        MovieArr.add(gold1)
        MovieArr.add(stampede1)
        MovieArr.add(timeskip1)
        MovieArr.add(strongworld1)
        MovieArr.add(z1)




    }
}


