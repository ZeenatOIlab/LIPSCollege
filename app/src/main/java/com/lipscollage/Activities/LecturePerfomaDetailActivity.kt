package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class LecturePerfomaDetailActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    private lateinit var noDataLayout: RelativeLayout
    lateinit var activity:LecturePerfomaDetailActivity
    lateinit var courselpDetailTextView:TextView
    lateinit var semlpDetailTextView:TextView
    lateinit var subjectlpDetailTextView:TextView
    lateinit var fecutylpDetailTextView:TextView
    lateinit var total_lecturelpDetailTextView:TextView
    lateinit var lpDetailRecyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture_perfoma_detail)
        var customactionbarObj= SetCustomActionBar()
        activity=this@LecturePerfomaDetailActivity
        customactionbarObj.setCustomBar(activity,"Lecture Perfoma Detail","lpd  etail")
        initViews()
    }
    private fun initViews()
    {
        noDataLayout=findViewById(R.id.noDataLayout)
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
        courselpDetailTextView=findViewById(R.id.courselpDetailTextView)
        semlpDetailTextView=findViewById(R.id.semlpDetailTextView)
        subjectlpDetailTextView=findViewById(R.id.subjectlpDetailTextView)
        fecutylpDetailTextView=findViewById(R.id.fecutylpDetailTextView)
        total_lecturelpDetailTextView=findViewById(R.id.total_lecturelpDetailTextView)
        lpDetailRecyclerView=findViewById(R.id.lpDetailRecyclerView)
    }
}