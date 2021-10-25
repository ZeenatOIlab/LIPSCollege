package com.lipscollage.Models

import com.google.gson.annotations.SerializedName

class LectureperformaModel {
    @SerializedName("result")
    var result:String=""

    @SerializedName("lecture_performa")
    lateinit var lecture_performadataList: MutableList<LectureperformaModel.LecturePerformaDataModel>


    class LecturePerformaDataModel
    {
        @SerializedName("p_id")
        var p_id:String=""

        @SerializedName("course")
        var course:String=""

        @SerializedName("sem")
        var sem:String=""

        @SerializedName("subject_name")
        var subject_name:String=""

        @SerializedName("feculty_name")
        var feculty_name:String=""

        @SerializedName("total_lecture")
        var total_lecture:String=""

    }
}