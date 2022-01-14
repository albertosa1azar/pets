package com.example.pets.data.network.entity

import com.squareup.moshi.Json


data class CatBreedResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "temperament") val temperament: String,
    @Json(name = "description") val description: String,
    @Json(name = "origin") val origin: String,
    @Json(name = "country_code") val country_code: String,
    @Json(name = "image") val image: CatImageResponse?,
)