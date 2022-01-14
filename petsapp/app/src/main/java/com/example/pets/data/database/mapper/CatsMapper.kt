package com.example.pets.data.database.mapper

import com.example.pets.data.database.entity.CatBreedEntity
import com.example.pets.domain.entity.CatBreed

fun CatBreedEntity.toCatBreed() = CatBreed(id, name, description,temperament, origin, country_code,image,isFavorite)

fun CatBreed.toEntity() = CatBreedEntity(id, name, description,temperament, origin, country_code,imageUrl,isFavorite)