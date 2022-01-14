package com.example.pets.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pets.data.database.dao.CatsDao
import com.example.pets.data.database.entity.CatBreedEntity

@Database(entities = [CatBreedEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getCatsDao(): CatsDao

    companion object {
        private const val DATABASE_NAME = "cats-db"
        fun create(application: Application): AppDataBase {
            return Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}