package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Adapters.DashboardAdapter.MyViewHolder
import com.lipscollage.Models.DashboardModel
import com.lipscollage.R
import java.util.*

class DashboardAdapter(var dashList:MutableList<DashboardModel>,var context: Context,
                      ) :
    RecyclerView.Adapter<MyViewHolder>() {
    lateinit var onItemclickListner: OnItemClickListner
    interface OnItemClickListner{
        fun onItemClickListner(pos:Int)
    }

    fun setOnClickListner(onItemclickListner: OnItemClickListner)
   {
       this.onItemclickListner = onItemclickListner

   }
    inner class MyViewHolder(itemView: View,onItemclickListner: OnItemClickListner) :
        RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val tittleTextView: TextView = itemView.findViewById(R.id.dashTextView)
        val dashImageView: ImageView = itemView.findViewById(R.id.dashImageView)
        val dashLayout: LinearLayout = itemView.findViewById(R.id.dashLayout)
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

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashborad_layout_row, parent, false)

        return MyViewHolder(view,onItemclickListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tittleTextView.text = dashList[position].tittle
        holder.dashImageView.setImageResource(dashList[position].image)
        val androidColors = context.resources.getIntArray(R.array.androidcolors)
        val randomAndroidColor = androidColors[Random().nextInt(androidColors.size)]
        holder.dashLayout.setBackgroundColor(randomAndroidColor);

    }

    override fun getItemCount(): Int {
       return dashList.size
    }

}