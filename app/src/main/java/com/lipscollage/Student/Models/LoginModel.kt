package com.lipscollage.Models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

 class LoginModel{
    @SerializedName("result")
    var result: String=""

    @SerializedName("data")
    val data: LoginData?=null


}





