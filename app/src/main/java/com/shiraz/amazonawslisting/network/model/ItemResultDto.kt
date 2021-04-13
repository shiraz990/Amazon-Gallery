package com.shiraz.amazonawslisting.network.model

import com.google.gson.annotations.SerializedName

data class ItemResultDto(

        @SerializedName("created_at")
        var created_at: String,

        @SerializedName("price")
        var price: String,

        @SerializedName("name")
        var name: String,

        @SerializedName("uid")
        var uid: String,

        @SerializedName("image_ids")
        val image_ids : List<String>,

        @SerializedName("image_urls")
        val image_urls : List<String>,

        @SerializedName("image_urls_thumbnails")
        val image_urls_thumbnails : List<String>
)