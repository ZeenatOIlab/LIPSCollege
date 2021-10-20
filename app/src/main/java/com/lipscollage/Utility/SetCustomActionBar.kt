package com.lipscollage.Utility

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.lipscollage.Activities.ProfileActivity
import com.lipscollage.R

 class SetCustomActionBar {
    public fun setCustomBar(context: AppCompatActivity, bar_name: String?, value: String) {
        val actionBar = context.supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(false)
        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        val view: View = context.layoutInflater.inflate(
            R.layout.custom_action_bar,
            null)
        val icn_back = view.findViewById<ImageView>(R.id.backImageView)
        val userImageView = view.findViewById<ImageView>(R.id.userImageView)
        icn_back.setOnClickListener { context.onBackPressed() }
        val barnameTextView = view.findViewById<TextView>(R.id.barnameTextView)
        barnameTextView.setText(bar_name)
        if(value.equals("dash")){
            icn_back.visibility=View.GONE
        }
        userImageView.setOnClickListener {
            if(value.equals("dash"))
            {
                context.startActivity(Intent(context,ProfileActivity::class.java))
            }

        }

        val layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT
        )
        actionBar.setCustomView(view, layoutParams)
        val parent = view.parent as Toolbar
        parent.setContentInsetsAbsolute(0, 0)
    }

}