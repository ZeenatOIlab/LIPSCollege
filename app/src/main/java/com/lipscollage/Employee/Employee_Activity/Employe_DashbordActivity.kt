package com.lipscollage.Employee.Employee_Activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Activities.DashboardActivity
import com.lipscollage.Activities.TimeTableActivity
import com.lipscollage.Adapters.DashboardAdapter
import com.lipscollage.Models.DashboardModel
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class Employe_DashbordActivity : AppCompatActivity() {
    lateinit var activity: Employe_DashbordActivity
    lateinit var progressDialog: AlertDialog
    lateinit var emp_dashRecyclerView: RecyclerView
    lateinit var dashboardAdapter: DashboardAdapter
    lateinit var dashList: MutableList<DashboardModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employe_dashbord)
        activity = this@Employe_DashbordActivity
        var customactionbarObj = SetCustomActionBar()
        customactionbarObj.setCustomBar(activity, "Employee Dashboard", "emp_dash")
        initViews()
        initRecyclerView()
    }
    private fun initViews() {
        emp_dashRecyclerView = findViewById(R.id.emp_dashRecyclerView)
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
    }
    private fun initRecyclerView()
    {
        getDashboardItem()
        val layoutManager = GridLayoutManager(this, 3)
        emp_dashRecyclerView.setLayoutManager(layoutManager)
        dashboardAdapter = DashboardAdapter(dashList, this)
        emp_dashRecyclerView.adapter = dashboardAdapter
        dashboardAdapter.setOnClickListner(object :DashboardAdapter.OnItemClickListner {
            override fun onItemClickListner(pos: Int) {
                Toast.makeText(activity,"click",Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun getDashboardItem() {
        dashList = mutableListOf()
        dashList.add(DashboardModel(R.drawable.chat, "Message To/From College", "message"))
        dashList.add(DashboardModel(R.drawable.icn_download, "Downloads \n", "download"))
        dashList.add(DashboardModel(R.drawable.attendance_icon, "Attendance \n", "attendance"))
        dashList.add(DashboardModel(R.drawable.leture_icon, "Lecture Perfoma \n ", "lecture"))
        dashList.add(DashboardModel(R.drawable.timetable_icon, "Time Table\n ", "timetable"))
        dashList.add(DashboardModel(R.drawable.calendar_icon, "Academic Calendar\n ", "calendar"))
        dashList.add(DashboardModel(R.drawable.rupee_icon, "Fees Details \n", "fees"))
    }
}