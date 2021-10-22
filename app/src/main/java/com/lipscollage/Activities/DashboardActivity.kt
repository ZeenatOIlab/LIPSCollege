package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.lipscollage.Adapters.DashboardAdapter
import com.lipscollage.Models.DashboardModel
import com.lipscollage.Models.DownloadDataModel
import com.lipscollage.Models.DownloadsModel
import com.lipscollage.Models.TransportModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.SetCustomActionBar
import com.lipscollage.Utility.sharedpreferenceClass
import com.rajat.pdfviewer.PdfViewerActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class DashboardActivity : AppCompatActivity() {
    lateinit var dashRecyclerView: RecyclerView
    lateinit var dashboardAdapter: DashboardAdapter
    lateinit var dashList: MutableList<DashboardModel>
    lateinit var activity: DashboardActivity
    lateinit var progressDialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        activity = this@DashboardActivity
        var customactionbarObj = SetCustomActionBar()
        customactionbarObj.setCustomBar(activity, "Dashboard", "dash")
        initViews()
        initRecyclerView()

    }

    private fun initViews() {
        dashRecyclerView = findViewById(R.id.dashRecyclerView)
        progressDialog = ProgressDialog(this@DashboardActivity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
    }

    private fun initRecyclerView() {
        getDashboardItem()
        val layoutManager = GridLayoutManager(this, 3)
        dashRecyclerView.setLayoutManager(layoutManager)
        dashboardAdapter = DashboardAdapter(dashList, this)
        dashRecyclerView.adapter = dashboardAdapter
        dashboardAdapter.setOnClickListner(object : DashboardAdapter.OnItemClickListner {
            override fun onItemClickListner(pos: Int) {
                if (dashList[pos].type.equals("timetable")) {
                    activity.startActivity(Intent(activity, TimeTableActivity::class.java))
                }
                else if (dashList[pos].type.equals("transport")) {
                    getTransaportData()
                }
                else if (dashList[pos].type.equals("canteen")) {
                    getCanteentData()
                }
                else if (dashList[pos].type.equals("download")) {
                    startActivity(Intent(activity,DownloadActivity::class.java))
                }
                else if (dashList[pos].type.equals("document")) {
                    startActivity(Intent(activity,DocumentDetailActivity::class.java))
                }
                else if (dashList[pos].type.equals("library")) {
                    startActivity(Intent(activity,LibraryActivity::class.java))
                }
                else if (dashList[pos].type.equals("lecture")) {
                    startActivity(Intent(activity,LecturePerfomaActivity::class.java))
                }
                else if (dashList[pos].type.equals("message")) {
                    startActivity(Intent(activity,MessageActivity::class.java))
                }
                else if (dashList[pos].type.equals("calendar")) {
                    startActivity(Intent(activity,CalendarActivity::class.java))
                }
                else if (dashList[pos].type.equals("fees")) {
                    startActivity(Intent(activity,FeesActivity::class.java))
                }
                else if (dashList[pos].type.equals("notice_board")) {
                    startActivity(Intent(activity,NoticeBoardActivity::class.java))
                }
                else if (dashList[pos].type.equals("attendance")) {
                    startActivity(Intent(activity,AttendanceActivity::class.java))
                }
            }
        })
    }
    private fun getDashboardItem() {
        dashList = mutableListOf()
        dashList.add(DashboardModel(R.drawable.chat, "Message To/From College", "message"))
        dashList.add(DashboardModel(R.drawable.icn_download, "Downloads \n", "download"))
        dashList.add(DashboardModel(R.drawable.attendance_icon, "Attendance \n", "attendance"))
        dashList.add(DashboardModel(R.drawable.leture_icon, "Lecture Perfoma \n ", "lecture"))
        dashList.add(DashboardModel(R.drawable.icon_notice_board, "Notice Board \n", "notice_board"))
        dashList.add(DashboardModel(R.drawable.timetable_icon, "Time Table\n ", "timetable"))
        dashList.add(DashboardModel(R.drawable.calendar_icon, "Academic Calendar\n ", "calendar"))
        dashList.add(DashboardModel(R.drawable.rupee_icon, "Fees Details \n", "fees"))
        dashList.add(DashboardModel(R.drawable.fork_icon, "College Canteen\n ", "canteen"))
        dashList.add(DashboardModel(R.drawable.icn_transport, "Transaport Details\n", "transport"))
        dashList.add(DashboardModel(R.drawable.icon_library, "Library\n", "library"))
        dashList.add(DashboardModel(R.drawable.box, "Document Detail\n", "document"))
        dashList.add(DashboardModel(R.drawable.results_icon, "Result\n", "result"))
        dashList.add(DashboardModel(R.drawable.complaint_icon, "Complaint\n", "complaint"))
        dashList.add(DashboardModel(R.drawable.information, "Record Updation Request", "record"))
        dashList.add(DashboardModel(R.drawable.icon_feedback, "Feedback Form", "feedback"))

    }

    fun getTransaportData() {
        progressDialog.show()
        val shared = sharedpreferenceClass(activity).sharedPref
        val response = APIClient.apiService.transport(shared.getString("cursession",""))
        System.out.println("transport param  = $response")

        response.enqueue(object : Callback<TransportModel> {
            override fun onResponse(
                call: Call<TransportModel>,
                response: Response<TransportModel>
            ) {
                progressDialog.dismiss()
                Log.e("TAG", "response 33: " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as TransportModel
                    if (model.result.equals("success")) {
                        val baseurl = "https://erp.luckyinstitute.org/parentlogin/"
                        this@DashboardActivity.startActivity(
                            PdfViewerActivity.launchPdfFromUrl(
                                this@DashboardActivity,
                                "$baseurl${model.file}",
                                "Transport Detail",
                                "",
                                enableDownload = false
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<TransportModel>, t: Throwable) {
                System.out.println("transport data t = $t")
                progressDialog.dismiss()

            }
        })

    }
    fun getCanteentData() {
        progressDialog.show()
        val shared = sharedpreferenceClass(activity).sharedPref

        val response = APIClient.apiService.getcanteen(shared.getString("cursession",""))

        response.enqueue(object : Callback<TransportModel> {
            override fun onResponse(
                call: Call<TransportModel>,
                response: Response<TransportModel>
            ) {
                progressDialog.dismiss()
                Log.e("TAG", "response 33: " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as TransportModel
                    if (model.result.equals("success")) {
                        val baseurl = "https://erp.luckyinstitute.org/parentlogin/"
                        this@DashboardActivity.startActivity(
                            PdfViewerActivity.launchPdfFromUrl(
                                this@DashboardActivity,
                                "$baseurl${model.file}",
                                "College Canteen",
                                "",
                                enableDownload = false
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<TransportModel>, t: Throwable) {
                System.out.println("transport data t = $t")
                progressDialog.dismiss()

            }
        })



    }



}