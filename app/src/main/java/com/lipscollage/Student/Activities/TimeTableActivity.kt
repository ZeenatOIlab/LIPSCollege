package com.lipscollage.Activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Adapters.TimeTableAdapter
import com.lipscollage.Models.TimeTableModel
import com.lipscollage.Models.TimeTableRowModel
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class TimeTableActivity : AppCompatActivity() {
    lateinit var activity: TimeTableActivity

    lateinit var timetableRecyclerView: RecyclerView
    lateinit var timeTableAdapter: TimeTableAdapter
    lateinit var timeList: MutableList<TimeTableModel>
    lateinit var timerowList: ArrayList<TimeTableRowModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)
        var customactionbarObj= SetCustomActionBar()
        activity=this@TimeTableActivity
        customactionbarObj.setCustomBar(activity,"Time Table","time")
        timeList = mutableListOf()
        timerowList = ArrayList()
        initViews()
        initRecyclerView()

    }
    fun initViews()
    {

        timetableRecyclerView=findViewById(R.id.timeTableRecyclerView)
    }
    private fun initRecyclerView()
    {

       getTimeTable()
        val layoutManager = LinearLayoutManager(this)
        timetableRecyclerView.setLayoutManager(layoutManager)
        timeTableAdapter = TimeTableAdapter(timeList, this)
        timetableRecyclerView.adapter = timeTableAdapter
    }
    private fun getTimeTable()
    {
        //add time tble list
        //monday
        var model1=TimeTableRowModel("09.00-10,","C++","101")
        timerowList.add(model1)
        var model2=TimeTableRowModel("09.00-10,","Java","102")
        timerowList.add(model2)
        var model3=TimeTableRowModel("09.00-10,","Kotlin","103")
        timerowList.add(model3)
        timeList.add(TimeTableModel("Monday",timerowList))

        //Tuesday
        timerowList.clear()
        var model11=TimeTableRowModel("09.00-10,","C++","101")
        timerowList.add(model11)
        var model22=TimeTableRowModel("09.00-10,","Java","102")
        timerowList.add(model22)
        var model33=TimeTableRowModel("09.00-10,","Kotlin","103")
        timerowList.add(model33)
        timeList.add(TimeTableModel("Tuesday",timerowList))

        //Wednesday
        timerowList.clear()
        var modelw1=TimeTableRowModel("09.00-10,","C++","101")
        timerowList.add(modelw1)
        var modelw2=TimeTableRowModel("09.00-10,","Java","102")
        timerowList.add(modelw2)
        var modelw3=TimeTableRowModel("09.00-10,","Kotlin","103")
        timerowList.add(modelw3)
        timeList.add(TimeTableModel("Wednesday",timerowList))


        //Thursday
        timerowList.clear()
        var modelt1=TimeTableRowModel("09.00-10,","C++","101")
        timerowList.add(modelt1)
        var modelt2=TimeTableRowModel("09.00-10,","Java","102")
        timerowList.add(modelt2)
        var modelt3=TimeTableRowModel("09.00-10,","Kotlin","103")
        timerowList.add(modelt3)
        timeList.add(TimeTableModel("Thursday",timerowList))

        //Friday
        timerowList.clear()
        var modelf1=TimeTableRowModel("09.00-10,","C++","101")
        timerowList.add(modelf1)
        var modelf2=TimeTableRowModel("09.00-10,","Java","102")
        timerowList.add(modelf2)
        var modelf3=TimeTableRowModel("09.00-10,","Kotlin","103")
        timerowList.add(modelf3)
        timeList.add(TimeTableModel("Friday",timerowList))

        //Saturday
        timerowList.clear()
        var models1=TimeTableRowModel("09.00-10,","C++","101")
        timerowList.add(models1)
        var models2=TimeTableRowModel("09.00-10,","Java","102")
        timerowList.add(models2)
        var models3=TimeTableRowModel("09.00-10,","Kotlin","103")
        timerowList.add(models3)
        timeList.add(TimeTableModel("Saturday",timerowList))



    }

}