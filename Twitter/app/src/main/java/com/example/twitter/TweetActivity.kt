package com.example.twitter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TweetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)
    }
    companion object{
        val PARAM_USER_ID="s"
        fun newIntent(context:Context)=Intent(context,HomeActivity::class.java)
    }
}