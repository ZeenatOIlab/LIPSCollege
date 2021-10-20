package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.TimeTableRowModel
import com.lipscollage.R

class TimeTableRowAdapter (var timerowList:MutableList<TimeTableRowModel>, var context: Context) :
    RecyclerView.Adapter<TimeTableRowAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time: TextView = itemView.findViewById(R.id.time)
        val subject: TextView = itemView.findViewById(R.id.subject)
        val room: TextView = itemView.findViewById(R.id.room)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.time_table_detail_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.time.text = timerowList[position].time
        holder.subject.text = timerowList[position].subject
        holder.room.text = timerowList[position].room


    }

    override fun getItemCount(): Int {
        return timerowList.size
    }

}