package com.lipscollage.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Models.DocumentModel
import com.lipscollage.R
import com.rajat.pdfviewer.PdfViewerActivity

class DocumentAdapter (var context: Context, var documentlist:MutableList<DocumentModel.DucumentDataModel>) :
    RecyclerView.Adapter<DocumentAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val document_name: TextView = itemView.findViewById(R.id.doc_nameTextView)
        var file_path: String=""
        val file_type: TextView = itemView.findViewById(R.id.docfiletypeTextView)
        val file_status: TextView = itemView.findViewById(R.id.docstatusTextView)
        val return_date: TextView = itemView.findViewById(R.id.docdateTextView)
        val remark: TextView = itemView.findViewById(R.id.docremarkTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.document_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.document_name.text ="Document Name : "+documentlist[position].document_name
        holder.file_path = documentlist[position].file_path.toString()
        holder.file_type.text ="File Type : "+documentlist[position].file_type
        holder.file_status.text ="File Status : "+documentlist[position].file_status
        holder.return_date.text ="Return Date : "+documentlist[position].return_date
        holder.remark.text ="Remark : "+documentlist[position].remarks

        holder.itemView.setOnClickListener {
            if(!documentlist[position].file_path.toString().equals(""))
            {
                val baseurl = "https://erp.luckyinstitute.org/parentlogin/"
                context.startActivity(
                    PdfViewerActivity.launchPdfFromUrl(

                        context,
                        "$baseurl${documentlist[position].file_path}",
                        "Document",
                        "",
                        enableDownload = false
                    )
                )
            }
            else{
                Toast.makeText(context,"File Not Available", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return documentlist.size
    }
}