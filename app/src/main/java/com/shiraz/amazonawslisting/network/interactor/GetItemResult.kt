package com.shiraz.amazonawslisting.network.interactor

import android.content.res.Resources
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.domain.state.DataState
import com.shiraz.amazonawslisting.repository.AmazonAWSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

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
        try {
            emit(DataState.Loading)
            val networkResult = networkDataSource.getList()
            networkResult.let {
                emit(DataState.Success(networkResult))
            }
        }
        catch (e: Exception){
            emit(DataState.Error(e))
        }


    }

}
















