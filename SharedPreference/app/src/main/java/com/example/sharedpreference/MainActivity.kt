package com.example.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
var count=0
var name:String?=null
var message:String?=null
var check:Boolean?=null
lateinit var shared:SharedPreferences
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.counter.setOnClickListener {
            count+=1
            binding.counter.setText(""+count)
        }

    }

    override fun onPause() {
        super.onPause()
        saveData()

    }

    override fun onResume() {
        super.onResume()
        shared=this.getSharedPreferences("saveData", MODE_PRIVATE)
        binding.message.setText(shared.getString("key message",null))
    }
    fun saveData(){
        shared=this.getSharedPreferences("saveData", MODE_PRIVATE)
        var editor=shared.edit()
        editor.putString("key name", binding.name.text.toString())
        editor.putString("key message", binding.message.text.toString())
        editor.putBoolean("key check", binding.checkBox.isChecked!!)
        editor.putString("key counter",binding.counter.text.toString())
        editor.apply()
        Toast.makeText(applicationContext, "Your data is saved", Toast.LENGTH_SHORT).show()

    }
}