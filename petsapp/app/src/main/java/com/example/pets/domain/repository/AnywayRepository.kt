package com.example.pets.domain.repository

import com.example.pets.domain.entity.Anyway

interface AnywayRepository {
    suspend fun getAnyway(): List<Anyway>
}