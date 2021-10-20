package com.lipscollage.Activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lipscollage.Models.LoginModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.sharedpreferenceClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var mobileEdittext:EditText
    lateinit var passwordEditText:EditText
    lateinit var collegeEditText:EditText
    lateinit var loginSubmitButton:Button
    lateinit var backImageView:ImageView
    lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        loginSubmitButton.setOnClickListener {
            if (mobileEdittext.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show()
            }  else if (passwordEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
            }else if (collegeEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter College Name", Toast.LENGTH_SHORT).show()
            } else {

                getLogin()
            }
        }
        backImageView.setOnClickListener { onBackPressed() }

    }
    private fun initViews()
    { mobileEdittext=findViewById(R.id.mobileEdittext)
        backImageView=findViewById(R.id.backImageView)
        passwordEditText=findViewById(R.id.passwordEditText)
        collegeEditText=findViewById(R.id.collegeEditText)
        loginSubmitButton=findViewById(R.id.loginSubmitButton)
         progressDialog = ProgressDialog(this@LoginActivity,R.style.CustomDialog)
        progressDialog.setCancelable(false)
    }

    fun getLogin()
    {
        progressDialog.show()
        val response = APIClient.apiService.getLogin(""+collegeEditText.text,""+passwordEditText.text,""+mobileEdittext.text)
        response.enqueue(object : Callback<LoginModel>{
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                progressDialog.dismiss()

                Log.e("TAG", "response login: " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as LoginModel
                    if (model.result.equals("success")) {
                      //  val logindata= model.data?.name
                          val shared = sharedpreferenceClass(this@LoginActivity).sharedPref
                        val editor = shared.edit()
                        editor.putBoolean("user_enrolled", true)
                        editor.putString("name",model.data?.name)
                        editor.putString("cursession",model.data?.cursession)
                        editor.putString("college_id",model.data?.college_id)
                        editor.putString("scholarno",model.data?.scholarno)
                        editor.putString("course",model.data?.course)
                        editor.putString("year",model.data?.year)
                        editor.putString("batch",model.data?.batch)
                        editor.putString("user_type",model.data?.user_type)
                        editor.putString("f_id",model.data?.f_id)
                        editor.commit()
                        Toast.makeText(this@LoginActivity,"${model.result}",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                    else{
                        Toast.makeText(this@LoginActivity,"${model.result}",Toast.LENGTH_SHORT).show()

                    }

                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity,"Something went wrong",Toast.LENGTH_SHORT).show()
            }

        })
    }


}


