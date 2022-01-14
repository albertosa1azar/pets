package com.example.pets.data.network.mapper

import com.example.pets.data.network.entity.CatImageResponse
import com.example.pets.domain.entity.CatImage

class CatImageMapper : DomainMapper<CatImageResponse, CatImage> {
    override fun toDomain(from: CatImageResponse) = CatImage(
        id = from.id,
        height = from.height,
        width = from.width,
        url = from.url,
    )

    override fun toDomain(from: List<CatImageResponse>) = from.map {
        toDomain(it)
    }
}