package com.example.layouts

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn=findViewById<Button>(R.id.button1)
        var txt1=findViewById<TextView>(R.id.text1)
        btn.setOnClickListener(object : View.OnClickListener {
             override fun onClick(view:View?){
                var inpt=txt1.text.toString()
                 val intent = Intent(applicationContext, MainActivity3::class.java)
                 startActivity(intent)
                 intent.putExtra("pora","poova")

            }
        })
        var btn2=findViewById<Button>(R.id.button2)

        btn2.setText("google")
        btn2.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View?){
                var i2=Intent(Intent.ACTION_VIEW)
                i2.setData(Uri.parse("https://www.google.com"))
                startActivity(i2)
            }

        }


        )


    }
}