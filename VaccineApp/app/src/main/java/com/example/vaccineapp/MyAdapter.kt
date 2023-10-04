package com.example.vaccineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(var listData:ArrayList<VaccineModel>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    //handle click events
    var clickListener: ItemClickListener? = null
    fun setClickListener(clickListener: ItemClickListener?){
        this.clickListener = clickListener
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View) {
            clickListener?.onClick(view, adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
         return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listData.get(position)
        holder.imageView.setImageResource(listData.get(position).image)
        holder.textView.text = listData.get(position).title
    }

}