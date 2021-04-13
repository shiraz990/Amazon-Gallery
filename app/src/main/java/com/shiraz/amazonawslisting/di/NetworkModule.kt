package com.shiraz.amazonawslisting.di

import com.shiraz.amazonawslisting.network.AmazonAWSListService
import com.shiraz.amazonawslisting.network.model.ItemResultDtoMapper
import com.google.gson.GsonBuilder
import com.shiraz.amazonawslisting.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideItemResultDtoMapper(): ItemResultDtoMapper {
        return ItemResultDtoMapper()
    }

    @Singleton
    @Provides
    fun provideAmazonAWSListService(): AmazonAWSListService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(AmazonAWSListService::class.java)
    }


}