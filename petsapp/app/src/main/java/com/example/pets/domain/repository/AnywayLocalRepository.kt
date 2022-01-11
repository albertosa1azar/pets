package com.example.pets.domain.repository

import com.example.pets.data.database.entity.AnywayEntity

interface AnywayLocalRepository {
    fun add(anywayEntity: AnywayEntity)
    fun remove(anywayEntity: AnywayEntity)
    fun getAll(): List<AnywayEntity>?
}