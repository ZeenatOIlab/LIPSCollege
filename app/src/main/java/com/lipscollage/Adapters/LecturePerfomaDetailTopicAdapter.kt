package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.LecturePerfomaDetailModel
import com.lipscollage.R

class LecturePerfomaDetailTopicAdapter(var context: Context,var topicList:MutableList<LecturePerfomaDetailModel.Topic>)
    :RecyclerView.Adapter<LecturePerfomaDetailTopicAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lpDetailTopicTextView: TextView = itemView.findViewById(R.id.lpDetailTopicTextView)
        val lpDetailSubTopicRecyclerView: RecyclerView = itemView.findViewById(R.id.lpDetailSubTopicRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.lecture_perfoma_detail_topic_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.lpDetailTopicTextView.text =topicList[position].topic_name
        holder.lpDetailSubTopicRecyclerView.layoutManager = LinearLayoutManager(context)
        var  subtopicAdapter = LecturePerfomaDetailSubTopicAdapter(context, topicList[position].sub_topic)
        holder.lpDetailSubTopicRecyclerView.adapter = subtopicAdapter
    }

    override fun getItemCount(): Int {
        return topicList.size
    }
}