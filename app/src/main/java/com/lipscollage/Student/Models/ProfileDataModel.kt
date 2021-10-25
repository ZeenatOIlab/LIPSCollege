package com.lipscollage.Models

import com.google.gson.annotations.SerializedName

class ProfileDataModel {
    @SerializedName("result")
    var result:String=""

    @SerializedName("name")
    var name:String=""

    @SerializedName("f_name")
    var f_name:String=""

    @SerializedName("m_name")
    var m_name:String=""

    @SerializedName("admission_date")
    var admission_date:String=""

    @SerializedName("admission_number")
    var admission_number:String=""

    @SerializedName("dob")
    var dob:String=""

    @SerializedName("address1")
    var address1:String=""

    @SerializedName("city")
    var city:String=""

    @SerializedName("state")
    var state:String=""

    @SerializedName("mobile1")
    var mobile1:String=""

    @SerializedName("mpbile2")
    var mpbile2:String=""

    @SerializedName("batch")
    var batch:String=""

    @SerializedName("course")
    var course:String=""

    @SerializedName("year")
    var year:String=""
}