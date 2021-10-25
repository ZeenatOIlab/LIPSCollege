package com.lipscollage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.lipscollage.Activities.DashboardActivity
import com.lipscollage.Utility.sharedpreferenceClass

class MainActivity : AppCompatActivity() {
    lateinit var studentLayout:LinearLayout
    lateinit var employeLayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        studentLayout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("login_type","student")
            startActivity(intent)

        }
        employeLayout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("login_type","employee")
            startActivity(intent)        }
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