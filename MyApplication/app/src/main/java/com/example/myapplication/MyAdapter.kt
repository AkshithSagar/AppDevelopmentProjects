package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MyAdapter(var data: List<County>, var context:Context): ArrayAdapter<County>(context,R.layout.itemlistlayout,data) {

    class ViewHolder() {


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        var datamodel = getItem(position)
        var viewholder: ViewHolder
        var result: View
        if (convertView == null) {
            viewholder= ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView=inflater.inflate(R.layout.itemlistlayout,parent,false)

        }


    }
}