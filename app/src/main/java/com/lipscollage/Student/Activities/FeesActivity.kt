package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lipscollage.Adapters.FeesAdapter
import com.lipscollage.Adapters.NoticeBoardAdapter
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar

class FeesActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    lateinit var activity:FeesActivity
    lateinit var feesRecyclerView:RecyclerView
    lateinit var feesAdapter: FeesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees)
        var customactionbarObj= SetCustomActionBar()
        activity=this@FeesActivity
        customactionbarObj.setCustomBar(activity,"Fees Details","fees")
        initViews()
        initRecyclerView()
    }
    private fun initViews()
    {
        progressDialog = ProgressDialog(activity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
        feesRecyclerView=findViewById(R.id.feesRecyclerView)
    }
    private fun initRecyclerView()
    {
        feesRecyclerView.layoutManager=LinearLayoutManager(activity)
        feesAdapter= FeesAdapter(activity)
        feesRecyclerView.adapter=feesAdapter
    }
}