package com.example.pets.data.network.mapper

import com.example.pets.data.network.entity.CatBreedResponse
import com.example.pets.domain.entity.CatBreed

class CatBreedMapper : DomainMapper<CatBreedResponse, CatBreed> {
    override fun toDomain(from: CatBreedResponse) = CatBreed(
        id = from.id,
        name = from.name,
        temperament = from.temperament,
        description = from.description,
        origin = from.origin,
        country_code = from.country_code,
        image = from.image?.let { CatImageMapper().toDomain(it) },
    )

    override fun toDomain(from: List<CatBreedResponse>) = from.map {
        toDomain(it)
    }
}