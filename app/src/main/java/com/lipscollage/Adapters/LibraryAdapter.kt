package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.LibraryModel
import com.lipscollage.R

class LibraryAdapter(var context: Context,var libraryList:MutableList<LibraryModel.LibraryDataModel>):
    RecyclerView.Adapter<LibraryAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val booknameTextView: TextView = itemView.findViewById(R.id.booknameTextView)
        val authorTextiew: TextView = itemView.findViewById(R.id.authorTextiew)
        val dateTextiew: TextView = itemView.findViewById(R.id.dateTextiew)
        val submission_dateTextiew: TextView = itemView.findViewById(R.id.submission_dateTextiew)
        val fneTextiew: TextView = itemView.findViewById(R.id.fneTextiew)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.library_book_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.booknameTextView.text =libraryList[position].book_name
        holder.authorTextiew.text =libraryList[position].author+","+libraryList[position].publisher
        holder.dateTextiew.text =libraryList[position].from_date+" To "+libraryList[position].to_date
        holder.submission_dateTextiew.text ="Submission date : "+libraryList[position].submission_date
        holder.fneTextiew.text ="Fine : "+libraryList[position].fine
    }

    override fun getItemCount(): Int {
        return libraryList.size
    }
}