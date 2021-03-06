package com.shiraz.amazonawslisting.repository

import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.network.AmazonAWSListService
import com.shiraz.amazonawslisting.network.model.ItemResultDtoMapper
import javax.inject.Inject

class AmazonAWSRepository_Impl @Inject constructor(
    private val amazonAWSListService: AmazonAWSListService,
    private val mapper: ItemResultDtoMapper,
): AmazonAWSRepository {

    override suspend fun getList(): List<ItemResult> {
        return mapper.toDomainList(amazonAWSListService.allList().results)
    }

}