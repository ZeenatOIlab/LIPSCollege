package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Adapters.LecturePerfomaDetailAdpter
import com.lipscollage.Adapters.LecturePerfomaDetailSubTopicAdapter
import com.lipscollage.Models.LecturePerfomaDetailModel
import com.lipscollage.R
import com.lipscollage.R.layout.activity_lecture_perfoma_detail
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
    lateinit var lecturerfomaDetailList:MutableList<LecturePerfomaDetailModel.Unit>
    lateinit var lecturerfomaDetailTopicList:MutableList<LecturePerfomaDetailModel.Topic>
    lateinit var lecturerfomaDetailbSubTopicList:MutableList<LecturePerfomaDetailModel.SubTopic>
    lateinit var lecturePerfomaDetailAdpter: LecturePerfomaDetailAdpter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_lecture_perfoma_detail)
        var customactionbarObj= SetCustomActionBar()
        activity=this@LecturePerfomaDetailActivity
        customactionbarObj.setCustomBar(activity,"Lecture Perfoma Detail","lpd  etail")
        initViews()
        setPerfomaData()
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
    private fun setPerfomaData()
    {
        data()
        lpDetailRecyclerView.layoutManager = LinearLayoutManager(activity)
          lecturePerfomaDetailAdpter = LecturePerfomaDetailAdpter(activity, lecturerfomaDetailList)
        lpDetailRecyclerView.adapter = lecturePerfomaDetailAdpter
    }
    private fun data()
    {
        lecturerfomaDetailList= mutableListOf()
        lecturerfomaDetailTopicList= mutableListOf()
        lecturerfomaDetailbSubTopicList= mutableListOf()

        var unitModel=LecturePerfomaDetailModel.Unit()
        unitModel.unit_name="Unit 1"

        var topicmodel=LecturePerfomaDetailModel.Topic()
        topicmodel.topic_name="PROGRAM CONCEPT"

        var subtopicmodel=LecturePerfomaDetailModel.SubTopic()
        subtopicmodel.sub_topic="CHARACTERISTICS OF PROGRAMMING"
        subtopicmodel.lecture_count="5"
        subtopicmodel.completed="2019-07-23"
        lecturerfomaDetailbSubTopicList.add(subtopicmodel)

        var subtopicmodel2=LecturePerfomaDetailModel.SubTopic()
        subtopicmodel2.sub_topic="VARIOUS STAGES IN PROGRAM, DEVELOPMENT PROGRAMMING AIDS ALGORITHMS"
        subtopicmodel2.lecture_count="5"
        subtopicmodel2.completed="2019-08-14"
        lecturerfomaDetailbSubTopicList.add(subtopicmodel2)

        var subtopicmodel3=LecturePerfomaDetailModel.SubTopic()
        subtopicmodel3.sub_topic="FLOW CHARTS - SYMBOLS, RULES FOR MAKING FLOW CHART, TYPES OF FLOWCHART"
        subtopicmodel3.lecture_count="2"
        subtopicmodel3.completed="2019-08-05"
        lecturerfomaDetailbSubTopicList.add(subtopicmodel3)


        topicmodel.sub_topic=lecturerfomaDetailbSubTopicList
        lecturerfomaDetailTopicList.add(topicmodel)

        unitModel.topic=lecturerfomaDetailTopicList
        lecturerfomaDetailList.add(unitModel)




    }
}