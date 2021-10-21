package com.lipscollage.Activities

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar
import java.util.*


class CalendarActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    lateinit var activity:CalendarActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        var customactionbarObj= SetCustomActionBar()
        activity=this@CalendarActivity
        customactionbarObj.setCustomBar(activity,"Academic Calendar","calendar")
        val events: MutableList<EventDay> = ArrayList()

        val calendar: Calendar = Calendar.getInstance()

        calendar.set(2021,10,22)
        events.add(EventDay(calendar, R.drawable.dot_shape, Color.parseColor("#228B22")))
//or
        val calendar1: Calendar = Calendar.getInstance()

        calendar1.set(2021,10,23)
//or
        events.add(EventDay(calendar1, R.drawable.dot_shape, Color.parseColor("#228B22")))
//or if you want to specify event label color
//or if you want to specify event label color
        val calendar2: Calendar = Calendar.getInstance()

        calendar2.set(2021,9,24)
        events.add(EventDay(calendar2, R.drawable.dot_shape, Color.parseColor("#228B22")))

        val calendarView: CalendarView = findViewById<View>(R.id.calendarView) as CalendarView
        calendarView.setEvents(events)

        calendarView.setOnDayClickListener { eventDay ->
            val clickedDayCalendar = eventDay.calendar
            System.out.println("event $clickedDayCalendar")

            val date:String = "${clickedDayCalendar.get(Calendar.DAY_OF_MONTH)}-${clickedDayCalendar.get(Calendar.MONTH)}" +
                    "-${clickedDayCalendar.get(Calendar.YEAR)}"

            Toast.makeText(this,date,Toast.LENGTH_SHORT).show()

        }


    }



}