package com.shiraz.amazonawslisting.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.shiraz.amazonawslisting.BaseApplication
import com.shiraz.amazonawslisting.BuildConfig
import com.shiraz.amazonawslisting.network.AmazonAWSListService
import com.shiraz.amazonawslisting.network.interactor.GetItemResult
import com.shiraz.amazonawslisting.network.model.ItemResultDtoMapper
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGetItemResultBlogs(
        networkDataSource: AmazonAWSRepository
    ): GetItemResult {
        return GetItemResult( networkDataSource)
    }

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

    @Singleton
    @Provides
    fun provideAmazonAWSRepository(
        amazonAWSListService: AmazonAWSListService,
        itemResultMapper: ItemResultDtoMapper,
    ): AmazonAWSRepository{
        return AmazonAWSRepository_Impl(
            amazonAWSListService = amazonAWSListService,
            mapper = itemResultMapper
        )
    }
}