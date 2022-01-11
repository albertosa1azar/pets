package com.example.pets.di

import com.example.pets.data.database.AppDataBase
import com.example.pets.data.network.RetrofitConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { AppDataBase.create(androidApplication()) }

}
