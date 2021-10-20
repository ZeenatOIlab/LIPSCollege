package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.JsonObject
import com.lipscollage.Adapters.TabPagerAdapter
import com.lipscollage.Models.ChangePasswordModel
import com.lipscollage.Models.TransportModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.SetCustomActionBar
import com.lipscollage.Utility.sharedpreferenceClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ProfileActivity : AppCompatActivity() {
    lateinit var activity: ProfileActivity
    lateinit var progressDialog: AlertDialog

    lateinit var profileTableLayout:TabLayout
     private lateinit var viewPager: ViewPager2
     private lateinit var nameTextView: TextView
     private lateinit var classsectionTextView: TextView
     private lateinit var rollnoTextView: TextView
     private lateinit var LogoutButton: Button
     private lateinit var ChangePassowrdButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var customactionbarObj= SetCustomActionBar()
        activity=this@ProfileActivity
        customactionbarObj.setCustomBar(activity,"Student Into","profile")
        initViews()
        LogoutButton.setOnClickListener {
            Toast.makeText(activity,"Please wait...", Toast.LENGTH_SHORT).show()
            progressDialog.show()
            deleteSharedPreferences(activity,"user_enrolled")
            val intent = Intent(activity,MainActivity::class.java)
            intent.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            progressDialog.dismiss()
            finish()

        }
        ChangePassowrdButton.setOnClickListener { changepassword_Dialog() }

    }
    fun initViews()
    { progressDialog = ProgressDialog(this@ProfileActivity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
        nameTextView=findViewById(R.id.nameTextView)
        classsectionTextView=findViewById(R.id.classsectionTextView)
        rollnoTextView=findViewById(R.id.rollnoTextView)
        LogoutButton=findViewById(R.id.LogoutButton)
        ChangePassowrdButton=findViewById(R.id.changePaswordButton)
        profileTableLayout=findViewById(R.id.profileTableLayout)
        viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val pagerAdapter = TabPagerAdapter(this)
        viewPager?.adapter = pagerAdapter

        TabLayoutMediator(profileTableLayout,viewPager){tab,position ->
            when(position){
                0 -> tab.text = "PERSONAL"
                1 -> tab.text = "PARENTS"
                2 -> tab.text = "TRANSPORT"
                3 -> tab.text = "OTHER"

            }
        }.attach()

       var shared = sharedpreferenceClass(activity).sharedPref
        nameTextView.text=shared.getString("name","name")
        classsectionTextView.text="Class : "+shared.getString("course","course")+" "+shared.getString("year","202")

    }
    fun deleteSharedPreferences(context: Context, name: String): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.deleteSharedPreferences(name)
        } else {
            context.getSharedPreferences(name, MODE_PRIVATE).edit().clear().apply()
            val dir = File(context.applicationInfo.dataDir, "shared_prefs")
            File(dir, "$name.xml").delete()
        }
    }
    private fun changepassword_Dialog() {
        //Inflate the dialog with custom view
        val dialog = LayoutInflater.from(this).inflate(R.layout.change_password_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(dialog)
            .setTitle("Change Password")
            .setCancelable(false)
        //show dialog
        val  mAlertDialog = mBuilder.show()
        val oldpasswordEdittext = dialog.findViewById(R.id.oldpasswordEdittext) as EditText
        val newpasswordEdittext = dialog.findViewById(R.id.newpasswordEdittext) as EditText
        val cancelTextView = dialog.findViewById(R.id.cancelTextView) as TextView
        val submitTextView = dialog.findViewById(R.id.submitTextView) as TextView
        cancelTextView.setOnClickListener {
            mAlertDialog.dismiss()
        }
        submitTextView.setOnClickListener {
            if(oldpasswordEdittext.text.equals(""))
            {
                Toast.makeText(activity,"Enter Old Password",Toast.LENGTH_SHORT).show()
            }
            if(newpasswordEdittext.text.equals(""))
            {
                Toast.makeText(activity,"Enter New Password",Toast.LENGTH_SHORT).show()
            }
            else{
                changePassword(oldpasswordEdittext.text.toString(),newpasswordEdittext.text.toString())
            }
            mAlertDialog.dismiss()
        }


    }
    private fun changePassword(oldString:String,newString:String)
    {
        progressDialog.show()
        var shared = sharedpreferenceClass(activity).sharedPref

        val response=APIClient.apiService.changePassword(shared.getString("cursession","")
            , shared.getString("scholarno",""),shared.getString("college_id",""),
            oldString,newString
        )
     response.enqueue(object :Callback<ChangePasswordModel>{
         override fun onResponse(
             call: Call<ChangePasswordModel>,
             response: Response<ChangePasswordModel>
         ) {
             System.out.println("Change passowrd: ${response.body().toString()}")
             progressDialog.dismiss()
             val model = response.body() as ChangePasswordModel
             Toast.makeText(activity,"${model.msg}",Toast.LENGTH_SHORT).show()

         }

         override fun onFailure(call: Call<ChangePasswordModel>, t: Throwable) {
             progressDialog.dismiss()
             Toast.makeText(activity,"Something went wrong",Toast.LENGTH_SHORT).show()

         }

     })

    }
}