package com.example.pets.data.network.mapper

import com.example.pets.data.network.entity.AnywayResponse
import com.example.pets.domain.entity.Anyway

class AnywayMapper: DomainMapper<AnywayResponse, Anyway>{
    override fun toDomain(from: AnywayResponse): Anyway {
        TODO("Not yet implemented")
    }

    override fun toDomain(from: List<AnywayResponse>): List<Anyway> {
        TODO("Not yet implemented")
    }
}