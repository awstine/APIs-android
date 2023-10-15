package com.example.api_android.data.remote.Repository

import android.util.Log
import com.example.api_android.ThroneUtil.Resource
import com.example.api_android.data.remote.ApiService
import com.example.api_android.data.remote.ThroneResponce

class ThroneRepository(
    private val apiService: ApiService,
) {
    suspend fun getThroneCharacters(): Resource<List<ThroneResponce>> {
        return try {
            val result = apiService.getCharacters()
            Log.d("ThroneRepository", "getThroneCharacters: $result")
            Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error(message = e.message ?: "An Error has occured")
        }
    }

    suspend fun getCharacterDetails(name: String): Resource<List<ThroneResponce>> {
        return try {
            val result = apiService.getCharacters()
            Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error(message = e.message ?: "An error has occured")
        }
    }
}