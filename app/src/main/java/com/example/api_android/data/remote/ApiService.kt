package com.example.api_android.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("/api/v2/Characters")
    fun getCharacters(): Call<List<ThroneResponce>>

    @GET("/api/v2/Characters/{id}")
    fun characterById(): Call<List<ThroneResponce>>

    @GET("/api/v2/Continents")
    fun getAllContinents(): Call<List<ThroneResponce>>
}