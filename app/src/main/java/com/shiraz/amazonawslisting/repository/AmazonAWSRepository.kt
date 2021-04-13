package com.shiraz.amazonawslisting.repository

import com.shiraz.amazonawslisting.domain.model.ItemResult


interface AmazonAWSRepository {

    suspend fun getList(): List<ItemResult>

}
