package com.example.api_android.Module

import com.example.api_android.data.remote.ApiService
import com.example.api_android.data.remote.Repository.ThroneRepository
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ThroneModule {
    // Provide a Retrofit instance for module
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://thronesapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide instance of ApiService using Retrofit instance
    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesDigimonRepository(apiService: ApiService): ThroneRepository {
        return ThroneRepository(apiService)
    }
}