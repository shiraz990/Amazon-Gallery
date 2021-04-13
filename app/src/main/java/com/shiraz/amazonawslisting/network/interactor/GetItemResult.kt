package com.shiraz.amazonawslisting.network.interactor

import com.codingwithmitch.daggerhiltplayground.business.domain.state.DataState
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetItemResult
constructor(
    private val networkDataSource: AmazonAWSRepository
){

    private val TAG: String = "AppDebug"

    /**
     * Show loading
     * Get Item Results from network
     * Show List<Results>
     */
    suspend fun execute(): Flow<DataState<List<ItemResult>>> = flow {
        emit(DataState.Loading)
        val networkResult = networkDataSource.getList()
        emit(DataState.Success(networkResult))
    }

}
















