package com.lipscollage.Models

import com.google.gson.annotations.SerializedName

class LibraryModel {
    @SerializedName("result")
    var result:String=""

    @SerializedName("book_active")
    lateinit var book_active: MutableList<LibraryModel.LibraryDataModel>

    @SerializedName("book_overdue")
    lateinit var book_overdue: MutableList<LibraryModel.LibraryDataModel>

    @SerializedName("book_return")
    lateinit var book_return: MutableList<LibraryModel.LibraryDataModel>

    class LibraryDataModel {
        @SerializedName("isbn_no")
        var isbn_no:String=""

        @SerializedName("acc_no")
        var acc_no:String=""

        @SerializedName("book_name")
        var book_name:String=""

        @SerializedName("author")
        var author:String=""

        @SerializedName("publisher")
        var publisher:String=""

        @SerializedName("from_date")
        var from_date:String=""

        @SerializedName("to_date")
        var to_date:String=""

        @SerializedName("submission_date")
        var submission_date:String=""

        @SerializedName("fine")
        var fine:String=""

        @SerializedName("other_fine")
        var other_fine:String=""
    }
}