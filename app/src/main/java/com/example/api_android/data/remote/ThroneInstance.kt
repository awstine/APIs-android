package com.example.api_android.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//we use instances so that they can be called on the main activity
object ThroneInstance{
    //THRONE INSTANCE

    //instance called --BY lazy-- created when needed
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://thronesapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //INSTANCE OF API SERVICE
    //we dont call it private because we want to call it on the main activity

    val ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }



}