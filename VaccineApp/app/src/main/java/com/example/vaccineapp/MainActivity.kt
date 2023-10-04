package com.example.vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //1. Adapter view
    lateinit var recyclerView: RecyclerView
    //2. create data source
    lateinit var data: ArrayList<VaccineModel>
    //3. create adpater
    lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        data= arrayListOf(
            VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine1),
            VaccineModel("Tetanus Vaccine", R.drawable.vaccine4),
            VaccineModel("Pneumococcal Vaccine", R.drawable.vaccine5),
            VaccineModel("Rotavirus Vaccine", R.drawable.vaccine6),
            VaccineModel("Measles Virus", R.drawable.vaccine7),
            VaccineModel("Cholera  Virus", R.drawable.vaccine8),
            VaccineModel("Covid-19 Virus", R.drawable.vaccine9)
        )
        adapter = MyAdapter(data)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter



    }
}