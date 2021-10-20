package com.lipscollage.Models

import com.google.gson.annotations.SerializedName

class DownloadDataModel {
    @SerializedName("id")
    var id:String="0"
    @SerializedName("title")
    var title:String=""
    @SerializedName("file_path")
    var file_path:String=""
    @SerializedName("subject")
    var subject:String=""

}