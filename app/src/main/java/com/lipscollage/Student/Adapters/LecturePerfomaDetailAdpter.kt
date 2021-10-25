package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.LecturePerfomaDetailModel
import com.lipscollage.Models.LectureperformaModel
import com.lipscollage.R

class LecturePerfomaDetailAdpter(var context: Context,var lpdetailList:MutableList<LecturePerfomaDetailModel.Unit>)
    : RecyclerView.Adapter<LecturePerfomaDetailAdpter.MyViewHolder>(){
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val lp_detail_unitTextView: TextView = itemView.findViewById(R.id.lp_detail_unitTextView)
        val lpDetailTopicRecyclerView: RecyclerView = itemView.findViewById(R.id.lpDetailTopicRecyclerView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.lecture_perfoma_detailrow,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.lp_detail_unitTextView.text =lpdetailList[position].unit_name
        holder.lpDetailTopicRecyclerView.layoutManager = LinearLayoutManager(context)
       var  topicAdapter = LecturePerfomaDetailTopicAdapter(context, lpdetailList[position].topic)
        holder.lpDetailTopicRecyclerView.adapter = topicAdapter

    }

    override fun getItemCount(): Int {
        return lpdetailList.size
    }
}