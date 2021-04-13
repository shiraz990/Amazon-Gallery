package com.shiraz.amazonawslisting.domain.model

import android.os.Parcel
import android.os.Parcelable

/**
 * See ItemResult from DataSource: https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/dynamodb-writer
 */
data class ItemResult(

    val created_at: String?,
    val price: String?,
    val name: String?,
    val uid: String?,
    val image_ids: String?,
    val image_urls: String?,
    val image_urls_thumbnails: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created_at)
        parcel.writeString(price)
        parcel.writeString(name)
        parcel.writeString(uid)
        parcel.writeString(image_ids)
        parcel.writeString(image_urls)
        parcel.writeString(image_urls_thumbnails)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemResult> {
        override fun createFromParcel(parcel: Parcel): ItemResult {
            return ItemResult(parcel)
        }

        override fun newArray(size: Int): Array<ItemResult?> {
            return arrayOfNulls(size)
        }
    }
}