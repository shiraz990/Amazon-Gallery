package com.shiraz.amazonawslisting.di

import com.shiraz.amazonawslisting.network.interactor.GetItemResult
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetItemResultBlogs(
        networkDataSource: AmazonAWSRepository
    ): GetItemResult {
        return GetItemResult( networkDataSource)
    }
}














