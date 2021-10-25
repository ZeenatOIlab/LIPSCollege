package com.lipscollage.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class MessageActivity : AppCompatActivity() {
    lateinit var activity:MessageActivity
    lateinit var messageEditText:EditText
    lateinit var messageSubmitButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        var customactionbarObj= SetCustomActionBar()
        activity=this@MessageActivity
        customactionbarObj.setCustomBar(activity,"Message ","message")
    }
    private fun initViews()
    {
        messageEditText=findViewById(R.id.messageEditText)
        messageSubmitButton=findViewById(R.id.messageSubmitButton)
    }
}