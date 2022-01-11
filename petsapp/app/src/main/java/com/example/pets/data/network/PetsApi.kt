package com.example.pets.data.network

import com.example.pets.data.network.entity.AnywayResponse
import retrofit2.http.GET

interface PetsApi {

    @GET("/")
    suspend fun getAnyway(): List<AnywayResponse>
}