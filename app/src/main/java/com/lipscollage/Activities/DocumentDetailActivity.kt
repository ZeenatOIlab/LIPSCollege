package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.lipscollage.Adapters.DocumentAdapter
import com.lipscollage.Adapters.DownloadAdapter
import com.lipscollage.Models.DocumentModel
import com.lipscollage.Models.DownloadDataModel
import com.lipscollage.Models.DownloadsModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.SetCustomActionBar
import com.lipscollage.Utility.sharedpreferenceClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DocumentDetailActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    private lateinit var noDataLayout: RelativeLayout
    lateinit var activity:DocumentDetailActivity
    lateinit var documentRecyclerView: RecyclerView
    lateinit var documentList:MutableList<DocumentModel.DucumentDataModel>
    lateinit var documentAdapter: DocumentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_detail)
        var customactionbarObj= SetCustomActionBar()
        activity=this@DocumentDetailActivity
        customactionbarObj.setCustomBar(activity,"Document Detail","document")
        initViews()
        getDocumentData()
    }
    private fun initViews()
    {
        documentRecyclerView=findViewById(R.id.documentRecyclerView)
        noDataLayout=findViewById(R.id.noDataLayout)
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)

    }
    fun getDocumentData() {
        progressDialog.show()

        val shared = sharedpreferenceClass(activity).sharedPref
        System.out.println("docment cursession="+shared.getString("cursession",""))
        System.out.println("docment scholarno="+shared.getString("scholarno",""))
        System.out.println("docment college_id="+shared.getString("college_id",""))
        val response = APIClient.apiService.getDocument("2019_20",
           "2046",shared.getString("college_id",""))

        response.enqueue(object : Callback<DocumentModel> {
            override fun onResponse(
                call: Call<DocumentModel>,
                response: Response<DocumentModel>
            ) {
                progressDialog.dismiss()
                Log.e("TAG", "Document " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as DocumentModel
                    if (model.result.equals("success")) {
                        if (model.document.size == 0) {
                            noDataLayout.isVisible = true
                            Toast.makeText(activity,"no data", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            noDataLayout.isVisible = false
                            documentList= mutableListOf()
                            documentList=model.document
                            documentRecyclerView.layoutManager = LinearLayoutManager(activity)
                            documentAdapter = DocumentAdapter(activity, documentList)
                            documentRecyclerView.adapter = documentAdapter

                        }
                    }
                    else{
                        Toast.makeText(activity,"${model.result}", Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<DocumentModel>, t: Throwable) {
                System.out.println("Document data t = $t")
                System.out.println("Document data call = ${call.toString()}")
                progressDialog.dismiss()
                Toast.makeText(activity,"Something went wrong", Toast.LENGTH_SHORT).show()

            }
        })



    }

}