package com.lipscollage.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Activities.LecturePerfomaDetailActivity
import com.lipscollage.Models.LectureperformaModel
import com.lipscollage.R

class LectureperformaAdapter (var context: Context, var lectureList:MutableList<LectureperformaModel.LecturePerformaDataModel>):
    RecyclerView.Adapter<LectureperformaAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coursenameTextView: TextView = itemView.findViewById(R.id.coursenameTextView)
        val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
        val feculty_nameTextView: TextView = itemView.findViewById(R.id.feculty_nameTextView)
        val semesterTextView: TextView = itemView.findViewById(R.id.semesterTextView)
        val total_lectureTextView: TextView = itemView.findViewById(R.id.total_lectureTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.lecture_perfoma_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.coursenameTextView.text =lectureList[position].course
        holder.subjectTextView.text =lectureList[position].subject_name
        holder.feculty_nameTextView.text =lectureList[position].feculty_name
        holder.semesterTextView.text =lectureList[position].sem
        holder.total_lectureTextView.text =lectureList[position].total_lecture
        holder.itemView.setOnClickListener {
            context.startActivity(
            Intent(context,
                LecturePerfomaDetailActivity::class.java)
        ) }
    }

    override fun getItemCount(): Int {
        return lectureList.size
    }
}