package com.lipscollage.Models

import com.google.gson.annotations.SerializedName

class LecturePerfomaDetailModel {
    @SerializedName("result")
    var result: String = ""

    @SerializedName("unit")
    lateinit var unitList: MutableList<Unit>

    class Unit {
        @SerializedName("unit_name")
        var unit_name: String = ""

        @SerializedName("topic")
        lateinit var topic: MutableList<Topic>
    }

    class Topic {
        @SerializedName("topic_name")
        var topic_name: String = ""

        @SerializedName("sub_topic")
        lateinit var sub_topic: MutableList<SubTopic>
    }

    class SubTopic {
        @SerializedName("sub_topic")
        var sub_topic: String = ""

        @SerializedName("lecture_count")
        var lecture_count: String = ""

        @SerializedName("completed")
        var completed: String = ""

    }

}