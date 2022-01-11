package com.example.pets.data.repository

import com.example.pets.data.database.AppDataBase
import com.example.pets.data.database.entity.AnywayEntity
import com.example.pets.domain.repository.AnywayLocalRepository

class AnywayLocalRepositoryImpl(
    appDataBase: AppDataBase
): AnywayLocalRepository {

    private val dao = appDataBase.getAnywayDao()

    override fun add(anywayEntity: AnywayEntity) {
        dao.add(anywayEntity)
    }

    override fun remove(anywayEntity: AnywayEntity) {
        dao.delete(anywayEntity)
    }

    override fun getAll(): List<AnywayEntity>? = dao.getAll()
}