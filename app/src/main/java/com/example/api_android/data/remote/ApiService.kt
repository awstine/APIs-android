package com.example.api_android.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService : List<ThroneResponce> {
    @GET ("/api/v2/Characters")
      suspend fun getCharacters(): List<ThroneResponce>

    @GET("/api/v2/Characters/{id}")
    suspend fun characterById(
        @Path("name")name: String,
    ): List<ThroneResponce>

    @GET("/api/v2/Continents")
    fun getAllContinents(): Call<List<ThroneResponce>>
}