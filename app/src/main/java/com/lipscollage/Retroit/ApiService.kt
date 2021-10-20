package com.lipscollage.Retroit

import com.google.gson.JsonObject
import com.lipscollage.Models.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    fun getLogin(@Field("college") college: String?,@Field("password") password: String?
    ,@Field("username") username: String?): Call<LoginModel>

    @FormUrlEncoded
    @POST("transport.php")
    fun transport(@Field("cursession") cursession: String?): Call<TransportModel>

    @FormUrlEncoded
    @POST("canteen.php")
    fun getcanteen(@Field("cursession") cursession: String?): Call<TransportModel>

    @FormUrlEncoded
    @POST("get-user-profile.php")
    fun getProfileData(@Field("cursession") cursession: String?,@Field("scholarno") scholarno: String?
                 ,@Field("college_id") college_id: String?): Call<ProfileDataModel>

    @FormUrlEncoded
    @POST("change-password.php")
    fun changePassword(@Field("cursession") cursession: String?,@Field("scholarno") scholarno: String?
                       ,@Field("college_id") college_id: String?
                       ,@Field("oldpwd") oldpwd: String?,
                       @Field("newpwd") newpwd: String?): Call<ChangePasswordModel>

    @FormUrlEncoded
    @POST("download.php")
    fun getDownloads(@Field("cursession") cursession: String?,@Field("f_id") f_id: String?
                       ,@Field("college_id") college_id: String?): Call<DownloadsModel>

    @FormUrlEncoded
    @POST("documents.php")
    fun getDocument(@Field("cursession") cursession: String?,@Field("scholarno") scholarno: String?
                     ,@Field("college_id") college_id: String?): Call<DocumentModel>

    @FormUrlEncoded
    @POST("library.php")
    fun getLibrary(@Field("cursession") cursession: String?,@Field("scholarno") scholarno: String?
                    ,@Field("college_id") college_id: String?): Call<LibraryModel>

    @FormUrlEncoded
    @POST("lectureperforma.php")
    fun getLectureperforma(@Field("cursession") cursession: String?,@Field("scholarno") scholarno: String?
                   ,@Field("college_id") college_id: String?): Call<LibraryModel>

}