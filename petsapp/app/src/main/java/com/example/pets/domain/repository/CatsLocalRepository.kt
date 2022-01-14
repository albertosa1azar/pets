package com.example.pets.domain.repository

import com.example.pets.data.database.entity.CatBreedEntity

interface CatsLocalRepository {
    fun add(catBreedEntity: CatBreedEntity)
    fun remove(catBreedEntity: CatBreedEntity)
    fun getAll(): List<CatBreedEntity>?
}