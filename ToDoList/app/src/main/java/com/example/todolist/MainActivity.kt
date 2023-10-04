package com.example.todolist

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.todolist.databinding.ActivityMainBinding

lateinit var bind:ActivityMainBinding
var itemlist= ArrayList<String>()
var filehelper=File()


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind= ActivityMainBinding.inflate(layoutInflater)
        val view= bind.root
        setContentView(view)

        val et= bind.ett
        val butt=bind.button
        val list=bind.list
        val lv=bind.lv

        itemlist= filehelper.readdata(this)
        var arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1, itemlist)
        lv.adapter=arrayAdapter
        butt.setOnClickListener {
            itemlist.add(et.text.toString())
            et.setText("")
            filehelper.write_data(itemlist,applicationContext)
            arrayAdapter.notifyDataSetChanged()

        }
    lv.setOnItemClickListener { adapterView, view, position, l ->

        val alert= AlertDialog.Builder(this)
        alert.setTitle("Delete")
        alert.setMessage("Do you want to delete this item from the list")
        alert.setCancelable(false)
        alert.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->dialogInterface.cancel()  })
        alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
            itemlist.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            filehelper.write_data(itemlist,applicationContext)
        })
        alert.create().show()
    }

    }
}