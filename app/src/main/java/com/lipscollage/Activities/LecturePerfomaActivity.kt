package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Adapters.DocumentAdapter
import com.lipscollage.Adapters.LectureperformaAdapter
import com.lipscollage.Adapters.TimeTableAdapter
import com.lipscollage.Models.DocumentModel
import com.lipscollage.Models.LectureperformaModel
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class LecturePerfomaActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    private lateinit var noDataLayout: RelativeLayout
    lateinit var activity:LecturePerfomaActivity
    lateinit var lecturePerfomaRecyclerView: RecyclerView
    lateinit var lectureList:MutableList<LectureperformaModel.LecturePerformaDataModel>
    lateinit var lectureperformaAdapter: LectureperformaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture_perfoma)
        var customactionbarObj= SetCustomActionBar()
        activity=this@LecturePerfomaActivity
        customactionbarObj.setCustomBar(activity,"Lecture Perfoma","lecture")
        initViews()
        getLecturePerfomaData()
    }
    private fun initViews()
    {
        lecturePerfomaRecyclerView=findViewById(R.id.lecturePerfomaRecyclerView)
        noDataLayout=findViewById(R.id.noDataLayout)
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)

    }
    private fun getLecturePerfomaData()
    {
        progressDialog.show()
        lectureList= mutableListOf()

        var moel=LectureperformaModel.LecturePerformaDataModel()
        moel.course="2019-20 - BBA - III YEAR"
        moel.sem="1"
        moel.subject_name="BUSINESS TAXATION"
        moel.feculty_name="Reena Jangid"
        moel.total_lecture="72"
        lectureList.add(moel)

        var moel2=LectureperformaModel.LecturePerformaDataModel()
        moel2.course="2019-20 - BBA - III YEAR"
        moel2.sem="1"
        moel2.subject_name="E - COMMERCE"
        moel2.feculty_name="Mamta  Arora"
        moel2.total_lecture="35"
        lectureList.add(moel2)

        var moel3=LectureperformaModel.LecturePerformaDataModel()
        moel3.course="2019-20 - BBA - III YEAR"
        moel3.sem="1"
        moel3.subject_name="FINANCIAL MANAGEMENT"
        moel3.feculty_name="DEEPAK BHATIA"
        moel3.total_lecture="69"
        lectureList.add(moel3)

        val layoutManager = LinearLayoutManager(this)
        lecturePerfomaRecyclerView.setLayoutManager(layoutManager)
        lectureperformaAdapter = LectureperformaAdapter(activity, lectureList)
        lecturePerfomaRecyclerView.adapter = lectureperformaAdapter
        progressDialog.dismiss()
    }
}