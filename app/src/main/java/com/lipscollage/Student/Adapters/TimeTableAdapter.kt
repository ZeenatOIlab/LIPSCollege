package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.TimeTableModel
import com.lipscollage.R

class TimeTableAdapter (var timeList:MutableList<TimeTableModel>, var context: Context) :
    RecyclerView.Adapter<TimeTableAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tittleTextView: TextView = itemView.findViewById(R.id.timenameTextView)
        val timetablerowRecyclerView: RecyclerView = itemView.findViewById(R.id.timetablerowRecyclerView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.timetable_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tittleTextView.text = timeList[position].name

        val layoutManager = LinearLayoutManager(context)
        holder.timetablerowRecyclerView.setLayoutManager(layoutManager)
        var adapter = TimeTableRowAdapter(timeList[position].timelist, context)
        holder.timetablerowRecyclerView.adapter = adapter


    }

    override fun getItemCount(): Int {
        return timeList.size
    }
}