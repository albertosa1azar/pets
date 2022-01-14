package com.example.pets.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pets.data.database.dao.AnywayDao
import com.example.pets.data.database.entity.AnywayEntity

@Database(entities = [AnywayEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getAnywayDao(): AnywayDao

    companion object {
        private const val DATABASE_NAME = ""
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