package com.example.pets.data.repository

import com.example.pets.data.network.CatsApi
import com.example.pets.data.network.mapper.CatBreedMapper
import com.example.pets.domain.entity.CatBreed
import com.example.pets.domain.repository.CatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatsRepositoryImpl(private val api: CatsApi, private val catBreedMapper: CatBreedMapper) :
    CatsRepository {

    override suspend fun getCatBreed(): List<CatBreed> {
        return withContext(Dispatchers.IO) {
            catBreedMapper.toDomain(api.getBreeds())
        }
    }

}