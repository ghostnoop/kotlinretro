package com.example.kotlinretro.api

import com.example.kotlinretro.models.Adversment
import com.example.kotlinretro.models.DefaultResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*
import retrofit2.http.GET
import java.net.URL
import com.example.kotlinretro.models.LoginResponse
import retrofit2.http.PUT
import retrofit2.http.FormUrlEncoded




interface Api {

    @FormUrlEncoded
    @POST("createuser")
    fun createUser(
        @Field("email") email:String,
        @Field("name") name:String,
         @Field("password") password:String,
        @Field("school") school:String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("userlogin")
    fun userLogin(
        @Field("email") email:String,
        @Field("password") password: String
    ):Call<LoginResponse>


    @FormUrlEncoded
    @POST("createads")
    fun createAds(
        @Field("img") img: String,
        @Field("name") name: String,
        @Field("days") days: String,
        @Field("phont") phont: String
    ):Call<DefaultResponse>


    @FormUrlEncoded
    @PUT("updateadver/{id}")
    fun updateAdver(
        @Path("id") id: Int,
        @Field("img") img: String,
        @Field("name") name: String,
        @Field("days") days: String,
        @Field("phont") phont: String
    ): Call<DefaultResponse>


    @GET("loadads")
    fun getAds(): Call<List<Adversment>>





//    @GET("users?q=rokano")
//    fun getUsers(): Call<DefaultResponse>

}