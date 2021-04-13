package com.shiraz.amazonawslisting.network

import com.shiraz.amazonawslisting.network.response.ItemResultResponse
import com.shiraz.amazonawslisting.utils.DYNAMODB_WRITTER
import retrofit2.http.GET


interface AmazonAWSListService {

    @GET(DYNAMODB_WRITTER)
    suspend fun allList(
    ): ItemResultResponse

}











