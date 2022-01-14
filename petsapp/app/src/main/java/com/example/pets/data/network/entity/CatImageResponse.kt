package com.example.pets.data.network.entity

import com.squareup.moshi.Json

data class CatImageResponse(
    @Json(name = "id") val id: String?,
    @Json(name = "width") val width: Long?,
    @Json(name = "height") val height: Long?,
    @Json(name = "url") val url: String?,
)