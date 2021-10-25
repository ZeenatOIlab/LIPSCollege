package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.R

class FeesAdapter (var context: Context):
    RecyclerView.Adapter<FeesAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //val booknameTextView: TextView = itemView.findViewById(R.id.booknameTextView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.fees_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      //  holder.booknameTextView.text =libraryList[position].book_name

    }

    override fun getItemCount(): Int {
        return 10
    }
}