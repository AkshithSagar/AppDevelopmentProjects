package com.example.recyclerview

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(public val context:Context, public val movieList:ArrayList<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(context).inflate(R.layout.mymovielayout,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(movieList.get(position).image)
        holder.name.setText(movieList.get(position).name)
        holder.hero.setText(movieList.get(position).hero)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val image:ImageView=itemView.findViewById(R.id.imageView)
        var name: TextView =itemView.findViewById<TextView>(R.id.moviename_tv)
        var hero: TextView =itemView.findViewById<TextView>(R.id.hero_tv)
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val pos=adapterPosition
            val context=itemView.context
            val builder = AlertDialog.Builder(context)
            builder.setIcon(androidx.constraintlayout.widget.R.drawable.abc_btn_check_to_on_mtrl_000)
            builder.setTitle(name.text)
            builder.setMessage("GOMU Gomu NOooooooooOOOOOO")
            builder.show()

            //Toast.makeText(context,name.text, Toast.LENGTH_SHORT).show()
        }

    }



}