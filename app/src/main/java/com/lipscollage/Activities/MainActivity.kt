package com.lipscollage.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.lipscollage.Activities.LoginActivity
import com.lipscollage.R
import com.lipscollage.Utility.sharedpreferenceClass

class MainActivity : AppCompatActivity() {
    lateinit var studentLayout:LinearLayout
    lateinit var employeLayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        studentLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))

        }
        employeLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }
    }
    fun initViews()
    {
        studentLayout=findViewById(R.id.studentLayout)
        employeLayout=findViewById(R.id.employeLayout)
    }
    override fun onStart() {
        super.onStart()
        //get user enrolled in preferences
        val shared = sharedpreferenceClass(this@MainActivity).sharedPref
        val isEnrolled = shared.getBoolean("user_enrolled", false)

        if (isEnrolled) {
            //user logged in using org credentials
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            finish()
        }
    }

}