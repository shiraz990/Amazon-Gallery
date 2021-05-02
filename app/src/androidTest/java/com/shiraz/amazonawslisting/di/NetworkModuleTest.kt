/*
package com.shiraz.amazonawslisting.di

import com.google.gson.GsonBuilder
import com.shiraz.amazonawslisting.network.AmazonAWSListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModuleTest{
    @Provides
    fun provideAmazonAWSListService(): AmazonAWSListService =
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
//            .baseUrl("http://127.0.0.1:8080") //  this too works
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(AmazonAWSListService::class.java)
}*/
