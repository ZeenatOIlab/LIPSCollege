package com.lipscollage.Models

import com.google.gson.annotations.SerializedName

class DocumentModel {
    @SerializedName("result")
    var result:String=""
    @SerializedName("document")
    lateinit var document: MutableList<DocumentModel.DucumentDataModel>

    class DucumentDataModel {
        @SerializedName("document_name")
        var document_name: String? = ""

        @SerializedName("file_path")
        var file_path: String? = ""

        @SerializedName("file_type")
        var file_type: String? = ""

        @SerializedName("file_status")
        var file_status: String? = ""

        @SerializedName("return_date")
        var return_date: String? = ""

        @SerializedName("remarks")
        var remarks: String? = ""
    }
}