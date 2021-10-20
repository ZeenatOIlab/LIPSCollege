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
import com.lipscollage.Adapters.DownloadAdapter
import com.lipscollage.Adapters.TimeTableAdapter
import com.lipscollage.Models.DownloadDataModel
import com.lipscollage.Models.DownloadsModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.SetCustomActionBar
import com.lipscollage.Utility.sharedpreferenceClass
import com.rajat.pdfviewer.PdfViewerActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.acos

class DownloadActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    private lateinit var noDataLayout: RelativeLayout
    lateinit var activity:DownloadActivity
   lateinit var downloadRecyclerview:RecyclerView
   lateinit var downloadList:MutableList<DownloadDataModel>
   lateinit var downloadAdapter: DownloadAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        var customactionbarObj= SetCustomActionBar()
        activity=this@DownloadActivity
        customactionbarObj.setCustomBar(activity,"Download","download")
        initViews()
        getDownloadData()

    }
    private fun initViews()
    {
        noDataLayout=findViewById(R.id.noDataLayout)
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
        downloadRecyclerview=findViewById(R.id.downloadRecyclerView)
    }

    fun getDownloadData() {
        progressDialog.show()

        val shared = sharedpreferenceClass(activity).sharedPref
        val response = APIClient.apiService.getDownloads("2020_21",
            shared.getString("f_id","1"),shared.getString("college_id","1"))

        response.enqueue(object : Callback<DownloadsModel> {
            override fun onResponse(
                call: Call<DownloadsModel>,
                response: Response<DownloadsModel>
            ) {
                progressDialog.dismiss()
                Log.e("TAG", "Downloads " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as DownloadsModel
                    if (model.result.equals("success")) {
                        if (model.download.size == 0) {
                            noDataLayout.isVisible = true
                            Toast.makeText(activity,"no data", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            noDataLayout.isVisible = false
                            downloadList= mutableListOf()
                            downloadList=model.download
                            downloadRecyclerview.layoutManager = LinearLayoutManager(activity)
                            downloadAdapter = DownloadAdapter(activity, downloadList)
                            downloadRecyclerview.adapter = downloadAdapter

                        }
                    }
                    else{
                        Toast.makeText(activity,"${model.result}", Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<DownloadsModel>, t: Throwable) {
                System.out.println("Downloads data t = $t")
                progressDialog.dismiss()
                Toast.makeText(activity,"Something went wrong", Toast.LENGTH_SHORT).show()

            }
        })



    }
}