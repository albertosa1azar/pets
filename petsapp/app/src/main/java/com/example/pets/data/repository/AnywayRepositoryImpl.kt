package com.example.pets.data.repository

import com.example.pets.data.network.PetsApi
import com.example.pets.data.network.mapper.AnywayMapper
import com.example.pets.domain.entity.Anyway
import com.example.pets.domain.repository.AnywayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnywayRepositoryImpl(
    private val api: PetsApi,
    private val anywayMapper: AnywayMapper
): AnywayRepository {

    override suspend fun getAnyway(): List<Anyway> {
        return withContext(Dispatchers.IO) {
            anywayMapper.toDomain(api.getAnyway())
        }
    }
}