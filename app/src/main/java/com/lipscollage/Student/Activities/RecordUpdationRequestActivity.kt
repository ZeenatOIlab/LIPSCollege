package com.lipscollage.Student.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Activities.FeesActivity
import com.lipscollage.R
import com.lipscollage.Student.Adapters.RecordUpdateDetailAdapter
import com.lipscollage.Utility.SetCustomActionBar

class RecordUpdationRequestActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    lateinit var activity: RecordUpdationRequestActivity
    lateinit var recordUpdateSpinner:Spinner
    lateinit var generate_reqTextView: TextView
    lateinit var req_detailTextView: TextView
    lateinit var messageSubmitButton: Button
    lateinit var recordViewSwitcher: ViewSwitcher
    lateinit var updateDetailRecyclerView: RecyclerView
    lateinit var recordUpdateDetailAdapter: RecordUpdateDetailAdapter
    private lateinit var recordArrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_updation_request)
        var customactionbarObj= SetCustomActionBar()
        activity=this@RecordUpdationRequestActivity
        customactionbarObj.setCustomBar(activity,"Record Updation Request","record")
        initViews()
        generate_reqTextView.setOnClickListener {
            generate_reqTextView.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.main))
            generate_reqTextView.setTextColor(resources.getColor(R.color.white))
            req_detailTextView.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.c1))
            req_detailTextView.setTextColor(resources.getColor(R.color.black))
            recordViewSwitcher.showNext()
        }
        req_detailTextView.setOnClickListener {
            req_detailTextView.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.main))
            req_detailTextView.setTextColor(resources.getColor(R.color.white))
            generate_reqTextView.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.c1))
            generate_reqTextView.setTextColor(resources.getColor(R.color.black))
            recordViewSwitcher.showPrevious()
        }

        recordArrayList = ArrayList()
        recordArrayList.add("--Select--")
        recordArrayList.add("SMS Contact No.")
        recordArrayList.add("Mobile No. 1")
        recordArrayList.add("Mobile No. 2")
        recordArrayList.add("Guardian Mobile No.")
        recordArrayList.add("Local Address")
        recordArrayList.add("Permanent Address")
        val adapter = object :
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, recordArrayList)
        {
            override fun isEnabled(position: Int): Boolean {

                return position != 0
            }
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                //set the color of first item in the drop down list to gray
                if(position == 0) {
                    view.setTextColor(Color.GRAY)
                } else {
                    //here it is possible to define color for other items by
                    //view.setTextColor(Color.RED)
                }
                return view
            }

        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        recordUpdateSpinner.adapter = adapter
        recordUpdateSpinner.setSelection(1)
        recordUpdateSpinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        recordUpdateSpinner.adapter = adapter
        recordUpdateSpinner.setSelection(1)
        recordUpdateSpinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }
    private fun initViews()
    {
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
        generate_reqTextView=findViewById(R.id.generate_reqTextView)
        req_detailTextView=findViewById(R.id.req_detailTextView)
        recordViewSwitcher=findViewById(R.id.recordViewSwitcher)
        messageSubmitButton=findViewById(R.id.messageSubmitButton)
        recordUpdateSpinner=findViewById(R.id.recordUpdateSpinner)
        updateDetailRecyclerView=findViewById(R.id.updateDetailRecyclerView)
        recordUpdateDetailAdapter=RecordUpdateDetailAdapter(activity)
        updateDetailRecyclerView.layoutManager=LinearLayoutManager(activity)
        updateDetailRecyclerView.adapter=recordUpdateDetailAdapter

    }
}