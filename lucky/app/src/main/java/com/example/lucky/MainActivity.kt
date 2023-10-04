package com.example.lucky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1=findViewById<Button>(R.id.button1)
        var edit1 = findViewById<EditText>(R.id.et1)


        button1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?){
                      var name=edit1.text.toString()
                var int= Intent(applicationContext,Act2::class.java)
                int.putExtra("name",name)

                startActivity(int)




            }

        })

    }
}