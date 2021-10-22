package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.LecturePerfomaDetailModel
import com.lipscollage.R

class LecturePerfomaDetailSubTopicAdapter (var context: Context, var subtopicList:MutableList<LecturePerfomaDetailModel.SubTopic>)
    : RecyclerView.Adapter<LecturePerfomaDetailSubTopicAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lpd_subtopicTextView: TextView = itemView.findViewById(R.id.lpd_subtopicTextView)
        val lpd_lecturecountTextView: TextView =
            itemView.findViewById(R.id.lpd_lecturecountTextView)
        val lpd_completedTextView: TextView = itemView.findViewById(R.id.lpd_completedTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lecture_perfoma_subtopic_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.lpd_subtopicTextView.text = subtopicList[position].sub_topic
        holder.lpd_lecturecountTextView.text = subtopicList[position].lecture_count
        holder.lpd_completedTextView.text = subtopicList[position].completed

    }
        override fun getItemCount(): Int {
            return subtopicList.size
        }

}