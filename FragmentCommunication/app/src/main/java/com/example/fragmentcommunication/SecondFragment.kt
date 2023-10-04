package com.example.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SecondFragment : Fragment() {

    var et2:EditText?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v=inflater.inflate(R.layout.fragment_second, container, false)
        et2=v.findViewById(R.id.et2)

        return v
    }
    public fun updateData(data:String){
        et2?.setText(data)

    }

    companion object {

    }
}