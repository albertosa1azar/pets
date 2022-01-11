package com.example.pets.data.database.mapper

import com.example.pets.domain.entity.Anyway
import com.example.pets.data.database.entity.AnywayEntity


fun AnywayEntity.toAnyway() = Anyway(id)

fun Anyway.toEntity() = AnywayEntity(id)