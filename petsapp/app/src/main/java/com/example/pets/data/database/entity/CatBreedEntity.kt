package com.example.pets.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatBreedEntity (
    @PrimaryKey val id: String,
    val name : String,
    val temperament : String,
    val description : String,
    val origin : String,
    val country_code : String,
    val image : String?,
    var isFavorite: Boolean
)