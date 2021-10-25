package com.lipscollage.Adapters


import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.NoticeBoardModel
import com.lipscollage.R


class NoticeBoardAdapter (var context: Context,var noticeList: MutableList<NoticeBoardModel>):
    RecyclerView.Adapter<NoticeBoardAdapter.MyViewHolder>(){


    lateinit var onItemclickListner: OnItemClickListner
    interface OnItemClickListner{
        fun onItemClickListner(pos:Int)
    }

    fun setOnClickListner(onItemclickListner: OnItemClickListner)
    {
        this.onItemclickListner = onItemclickListner

    }

   inner  class MyViewHolder(itemView: View,onItemclickListner:OnItemClickListner)
        : RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val noticeBoardTittleTextView: TextView = itemView.findViewById(R.id.noticeBoardtitleTextView)
        val noticeBoardDateTextView: TextView = itemView.findViewById(R.id.noticeBoarddateTextView)
        val noticeBoardDescTextView: TextView = itemView.findViewById(R.id.noticeBoardDescTextView)

        init {
            itemView.setOnClickListener(this)

        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemclickListner.onItemClickListner(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.notice_board_row,parent,false)
        return MyViewHolder(view,onItemclickListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pos: NoticeBoardModel = noticeList.get(position)
        holder.noticeBoardTittleTextView.text =noticeList[position].noticeBoardTitle
        holder.noticeBoardDateTextView.text =noticeList[position].noticeBoardDate
        holder.noticeBoardDescTextView.text =noticeList[position].noticeBoardDescription
        // Get the state
        val expanded: Boolean = pos.expanded
        // Set the visibility based on state
        holder.noticeBoardDescTextView.setVisibility(if (expanded) View.VISIBLE else View.GONE)
        holder.itemView.setOnClickListener { v ->
            // Get the current state of the item
            val expanded: Boolean =pos.expanded
            // Change the state
            pos.expanded=!expanded
            // Notify the adapter that item has changed
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return noticeList.size
    }
}