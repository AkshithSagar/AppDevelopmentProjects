package com.example.myapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.select_button)
        var check2=findViewById<CheckBox>(R.id.boy)
        var check1=findViewById<CheckBox>(R.id.game)
        
        button.setOnClickListener (object: View.OnClickListener{
            override fun onClick(view:View?){
                if(check1.isChecked){
                    Toast.makeText(this@MainActivity, "GAMER", Toast.LENGTH_SHORT).show()
                }
                if(check2.isChecked){
                    Toast.makeText(this@MainActivity, "Boyer", Toast.LENGTH_SHORT).show()

                }

                
            }
            
        })

    }



}