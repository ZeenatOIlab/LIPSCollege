package com.lipscollage.Models

import com.google.gson.annotations.SerializedName
import android.graphics.ColorSpace.Model

import com.google.gson.annotations.Expose


class DownloadsModel {
    @SerializedName("result")
    var result: String = ""

    @SerializedName("download")
    lateinit var download: ArrayList<DownloadDataModel>

}