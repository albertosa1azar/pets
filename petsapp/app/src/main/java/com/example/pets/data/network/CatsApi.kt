package com.example.pets.data.network

import com.example.pets.data.network.entity.CatBreedResponse
import retrofit2.http.GET

interface CatsApi {
    @GET("breeds")
    suspend fun getBreeds(): List<CatBreedResponse>
}