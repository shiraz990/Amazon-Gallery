package com.shiraz.amazonawslisting.network.response

import com.shiraz.amazonawslisting.network.model.ItemResultDto
import com.google.gson.annotations.SerializedName

data class ItemResultResponse(


        @SerializedName("results")
        var results: List<ItemResultDto>,
)