package com.example.fragmentcommunication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FirstFragment : Fragment() {
    var listener: FirstFragmentListener? =null
    var button1:Button?=null
    var et1:EditText?=null

public interface FirstFragmentListener{
    fun sendDataToSecond(data:String){

    }
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var v=inflater.inflate(R.layout.fragment_first, container, false)
        button1=v.findViewById<Button>(R.id.bt1)
        et1=v.findViewById<EditText>(R.id.et1)

        button1?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                listener?.sendDataToSecond(et1?.text.toString().trim())
            }
        })
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstFragmentListener) {
            listener = context
        } else {
            Toast.makeText(context, "Implenet a listener", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

    }
}