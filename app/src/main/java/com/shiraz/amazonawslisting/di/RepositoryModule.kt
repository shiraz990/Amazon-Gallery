package com.shiraz.amazonawslisting.di

import com.shiraz.amazonawslisting.network.AmazonAWSListService
import com.shiraz.amazonawslisting.network.model.ItemResultDtoMapper
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

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

