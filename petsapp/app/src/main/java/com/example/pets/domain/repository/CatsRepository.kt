package com.example.pets.domain.repository

import com.example.pets.domain.entity.CatBreed

interface CatsRepository {
    suspend fun getCatBreed(): List<CatBreed>
}