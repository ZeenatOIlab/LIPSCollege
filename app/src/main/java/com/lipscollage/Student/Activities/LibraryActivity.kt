package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.lipscollage.Adapters.DocumentAdapter
import com.lipscollage.Adapters.DownloadAdapter
import com.lipscollage.Adapters.LibraryAdapter
import com.lipscollage.Models.DocumentModel
import com.lipscollage.Models.DownloadDataModel
import com.lipscollage.Models.LibraryModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.SetCustomActionBar
import com.lipscollage.Utility.sharedpreferenceClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LibraryActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    lateinit var activity:LibraryActivity
    lateinit var activebookRecyclerView: RecyclerView
    lateinit var overduebookRecyclerView: RecyclerView
    lateinit var returnduebookRecyclerView: RecyclerView
    lateinit var activeList:MutableList<LibraryModel.LibraryDataModel>
    lateinit var overList:MutableList<LibraryModel.LibraryDataModel>
    lateinit var returnList:MutableList<LibraryModel.LibraryDataModel>
    lateinit var libraryAdapter: LibraryAdapter
    //no data text for list
    lateinit var noactivebookTextView: TextView
    lateinit var noaoverbookTextView: TextView
    lateinit var noreturnbookTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        var customactionbarObj= SetCustomActionBar()
        activity=this@LibraryActivity
        customactionbarObj.setCustomBar(activity,"Library","library")
        initViews()
        getLibraryData()
    }
    private fun initViews()
    {
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
        activebookRecyclerView=findViewById(R.id.activebookRecyclerView)
        overduebookRecyclerView=findViewById(R.id.overduebookRecyclerView)
        returnduebookRecyclerView=findViewById(R.id.returnduebookRecyclerView)

        noactivebookTextView=findViewById(R.id.noactivebookTextView)
        noaoverbookTextView=findViewById(R.id.noaoverbookTextView)
        noreturnbookTextView=findViewById(R.id.noreturnbookTextView)
    }
    fun getLibraryData() {
        progressDialog.show()

        val shared = sharedpreferenceClass(activity).sharedPref
        System.out.println("docment cursession="+shared.getString("cursession",""))
        System.out.println("docment scholarno="+shared.getString("scholarno",""))
        System.out.println("docment college_id="+shared.getString("college_id",""))
        val response = APIClient.apiService.getLibrary("2019_20",
            "2046",shared.getString("college_id",""))

        response.enqueue(object : Callback<LibraryModel> {
            override fun onResponse(
                call: Call<LibraryModel>,
                response: Response<LibraryModel>
            ) {
                progressDialog.dismiss()
                Log.e("TAG", "Document " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as LibraryModel
                    if (model.result.equals("success")) {
                        //active list
                        if (model.book_active.size == 0) {
                            noactivebookTextView.isVisible = true
                            Toast.makeText(activity,"no active book", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            noactivebookTextView.isVisible = false
                            activeList= mutableListOf()
                            activeList=model.book_active
                            activebookRecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
                            libraryAdapter = LibraryAdapter(activity, activeList)
                            activebookRecyclerView.adapter = libraryAdapter

                        }
                        //overdue list
                        if (model.book_overdue.size == 0) {
                            noaoverbookTextView.isVisible = true
                            Toast.makeText(activity,"no overdue book", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            noaoverbookTextView.isVisible = false
                            overList= mutableListOf()
                            overList=model.book_overdue
                            overduebookRecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
                            libraryAdapter = LibraryAdapter(activity, overList)
                            overduebookRecyclerView.adapter = libraryAdapter

                        }
                        //return list
                        if (model.book_return.size == 0) {
                             noreturnbookTextView.isVisible = true
                            Toast.makeText(activity,"no return book", Toast.LENGTH_SHORT).show()
                        }
                        else{
                               noreturnbookTextView.isVisible = false
                            returnList= mutableListOf()
                            returnList=model.book_return
                            returnduebookRecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
                            libraryAdapter = LibraryAdapter(activity, returnList)
                            returnduebookRecyclerView.adapter = libraryAdapter

                        }
                    }
                    else{
                        Toast.makeText(activity,"${model.result}", Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<LibraryModel>, t: Throwable) {
                System.out.println("Document data t = $t")
                progressDialog.dismiss()
                Toast.makeText(activity,"Something went wrong", Toast.LENGTH_SHORT).show()

            }
        })



    }
}