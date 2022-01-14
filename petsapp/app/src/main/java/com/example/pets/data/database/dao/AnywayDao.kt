package com.example.pets.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pets.data.database.entity.AnywayEntity

@Dao
interface AnywayDao {

    @Insert
    fun add(coffeeEntity: AnywayEntity)

    @Delete
    fun delete(coffeeEntity: AnywayEntity)

    @Query("SELECT * FROM AnywayEntity")
    fun getAll(): List<AnywayEntity>?
}