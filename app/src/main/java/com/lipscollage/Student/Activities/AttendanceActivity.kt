package com.lipscollage.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class AttendanceActivity : AppCompatActivity() {
    lateinit var activity:AttendanceActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)
        var customactionbarObj= SetCustomActionBar()
        activity=this@AttendanceActivity
        customactionbarObj.setCustomBar(activity,"Attendance","calendar")
    }
}