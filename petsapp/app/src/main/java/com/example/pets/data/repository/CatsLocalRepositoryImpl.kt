package com.example.pets.data.repository

import com.example.pets.data.database.AppDataBase
import com.example.pets.data.database.entity.CatBreedEntity
import com.example.pets.domain.repository.CatsLocalRepository

class CatsLocalRepositoryImpl(
    appDataBase: AppDataBase
) : CatsLocalRepository {

    private val dao = appDataBase.getCatsDao()

    override fun add(catBreedEntity: CatBreedEntity) {
        dao.add(catBreedEntity)
    }

    override fun remove(catBreedEntity: CatBreedEntity) {
        dao.delete(catBreedEntity)
    }

    override fun getAll(): List<CatBreedEntity>? = dao.getAll()

}