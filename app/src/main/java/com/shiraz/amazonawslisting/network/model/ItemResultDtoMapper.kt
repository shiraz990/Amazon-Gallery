package com.shiraz.amazonawslisting.network.model

import com.shiraz.amazonawslisting.domain.util.DomainMapper
import com.shiraz.amazonawslisting.domain.model.ItemResult

class ItemResultDtoMapper : DomainMapper<ItemResultDto, ItemResult> {

    override fun mapToDomainModel(model: ItemResultDto): ItemResult {
        return  ItemResult(
            created_at = model.created_at,
            price = model.price,
            name = model.name,
            uid = model.uid,
            image_ids = model.image_ids[0],
            image_urls = model.image_urls[0],
            image_urls_thumbnails = model.image_urls_thumbnails[0]
        )
    }


    fun toDomainList(initial: List<ItemResultDto>): List<ItemResult>{
        return initial.map { mapToDomainModel(it) }
    }



}
