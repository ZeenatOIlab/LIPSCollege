package com.lipscollage.Fragments

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.lipscollage.Activities.ProfileActivity
import com.lipscollage.Models.LoginModel
import com.lipscollage.Models.ProfileDataModel
import com.lipscollage.R
import com.lipscollage.Retroit.APIClient
import com.lipscollage.Utility.sharedpreferenceClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile_PersonalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile_PersonalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var profileActivity: ProfileActivity? = null
    lateinit var usernameTextView: TextView
    lateinit var fathernameTextView: TextView
    lateinit var mothernameTextView: TextView
    lateinit var dobTextView: TextView
    lateinit var admission_dateTextView: TextView
    lateinit var admission_numberTextView: TextView
    lateinit var address1TextView: TextView
    lateinit var cityTextView: TextView
    lateinit var stateTextView: TextView
    lateinit var mobile1TextView: TextView
    lateinit var mobile2TextView: TextView
    lateinit var batchTextView: TextView
    lateinit var courseTextView: TextView
    lateinit var yearTextView: TextView
    lateinit var progressDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile__personal, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile_PersonalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile_PersonalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)
        getProfileData()
    }

    fun initviews(view: View)
    {
        profileActivity = activity as ProfileActivity?
        progressDialog = ProgressDialog(profileActivity, R.style.CustomDialog)
        progressDialog.setCancelable(false)
        usernameTextView=view.findViewById(R.id.usernameTextView)
        fathernameTextView=view.findViewById(R.id.fathernameTextView)
        mothernameTextView=view.findViewById(R.id.mothernameTextView)
        dobTextView=view.findViewById(R.id.dobTextView)
        admission_dateTextView=view.findViewById(R.id.admission_dateTextView)
        admission_numberTextView=view.findViewById(R.id.admission_numberTextView)
        address1TextView=view.findViewById(R.id.address1TextView)
        cityTextView=view.findViewById(R.id.cityTextView)
        stateTextView=view.findViewById(R.id.stateTextView)
        mobile1TextView=view.findViewById(R.id.mobile1TextView)
        mobile2TextView=view.findViewById(R.id.mobile2TextView)
        batchTextView=view.findViewById(R.id.batchTextView)
        courseTextView=view.findViewById(R.id.courseTextView)
        yearTextView=view.findViewById(R.id.yearTextView)
    }
    private fun getProfileData()
    {
        progressDialog.show()
        val shared = sharedpreferenceClass(requireContext()).sharedPref
        val response=APIClient.apiService.getProfileData(shared.getString("cursession",""),
            shared.getString("scholarno",""),
            shared.getString("college_id",""))
        response.enqueue(object : Callback<ProfileDataModel>{
            override fun onResponse(
                call: Call<ProfileDataModel>,
                response: Response<ProfileDataModel>
            ) {
                progressDialog.dismiss()
                Log.e("TAG", "response profile: " + Gson().toJson(response.body()))
                if (response.code() == 200) {
                    val model = response.body() as ProfileDataModel
                    if (model.result.equals("success")) {
                        usernameTextView.text=model.name
                        fathernameTextView.text=model.f_name
                        mothernameTextView.text=model.m_name
                        usernameTextView.text=model.name
                        dobTextView.text=model.dob
                        admission_dateTextView.text=model.admission_date
                        admission_numberTextView.text=model.admission_number
                        address1TextView.text=model.address1
                        cityTextView.text=model.city
                        stateTextView.text=model.state
                        mobile1TextView.text=model.mobile1
                        mobile2TextView.text=model.mpbile2
                        batchTextView.text=model.batch
                        courseTextView.text=model.course
                        yearTextView.text=model.year

                    }
                    else{
                        Toast.makeText(profileActivity,"${model.result}", Toast.LENGTH_SHORT).show()

                    }
                }

            }

            override fun onFailure(call: Call<ProfileDataModel>, t: Throwable) {
                Log.e("TAG", "response profile: " +t.localizedMessage)
                Toast.makeText(profileActivity,"Something went wrong",Toast.LENGTH_SHORT).show()

                progressDialog.dismiss()

            }

        })
    }
}