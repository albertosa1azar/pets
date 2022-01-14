package com.example.pets.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pets.data.database.entity.CatBreedEntity

@Dao
interface CatsDao {

    @Insert
    fun add(catBreedEntity: CatBreedEntity)

    @Delete
    fun delete(catBreedEntity: CatBreedEntity)

    @Query("SELECT * FROM CatBreedEntity")
    fun getAll():List<CatBreedEntity>?
}