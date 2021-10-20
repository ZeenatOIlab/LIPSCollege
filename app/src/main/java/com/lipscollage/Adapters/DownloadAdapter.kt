package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.DownloadDataModel
import com.lipscollage.R
import com.rajat.pdfviewer.PdfViewerActivity

class DownloadAdapter(var context: Context,var downloadlist:MutableList<DownloadDataModel>) :
    RecyclerView.Adapter<DownloadAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.download_id_TextView)
        val title: TextView = itemView.findViewById(R.id.download_title_TextView)
        val subject: TextView = itemView.findViewById(R.id.download_subject_TextView)
        var file:String=""


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.download_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text ="Id : "+downloadlist[position].id
        holder.title.text ="Title : "+ downloadlist[position].title
        holder.subject.text = "Subject : "+downloadlist[position].subject
        holder.file = downloadlist[position].file_path
        holder.itemView.setOnClickListener {
            if(! downloadlist[position].file_path.equals(""))
            {
                val baseurl = "https://erp.luckyinstitute.org/parentlogin/"
                context.startActivity(
                    PdfViewerActivity.launchPdfFromUrl(

                        context,
                        "$baseurl${downloadlist[position].file_path}",
                        "Downloads",
                        "",
                        enableDownload = false
                    )
                )
            }
            else{
                Toast.makeText(context,"File Not Available",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return downloadlist.size
    }
}