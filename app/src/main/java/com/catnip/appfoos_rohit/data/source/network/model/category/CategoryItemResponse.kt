package com.catnip.appfoos_rohit.data.source.network.model.category

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CategoryItemResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("nama")
    val nama: String?,
    @SerializedName("slug")
    val slug: String?,
)
