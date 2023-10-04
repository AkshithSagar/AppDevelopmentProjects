package com.example.lucky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class Act2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2)
        var textview2=findViewById<TextView>(R.id.textview2)
        var share=findViewById<Button>(R.id.button2)
        var num=findViewById<TextView>(R.id.textview3)
        if(savedInstanceState!=null)
        {
            var rand2=savedInstanceState.getInt("rand")
            num.setText(""+rand2)
        }
        else {

            var int2 = intent
            var username = int2.getStringExtra("name")
            var rand = gen()
            num.setText("" + rand)

            share.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    sharedata(username, rand)

                }
            })
            onSaveInstanceState(rand)
        }

    }
    fun gen(): Int {
  return (0..1000).random()
    }


    fun sharedata(username:String?, number:Int){
        var i=Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        var curr=number.toString()

        i.putExtra(Intent.EXTRA_SUBJECT,username)
        i.putExtra(Intent.EXTRA_TEXT,curr)

        startActivity(Intent.createChooser(i,"choose platform"))


    }

    fun onSaveInstanceState(rand:Int) {

        var outState= Bundle()
        outState.putInt("rand",rand)
        super.onSaveInstanceState(outState)

    }
}