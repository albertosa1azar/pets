package com.example.pets.di

import com.example.pets.data.database.AppDataBase
import com.example.pets.data.network.RetrofitConfig
import com.example.pets.data.network.mapper.CatBreedMapper
import com.example.pets.data.repository.CatsLocalRepositoryImpl
import com.example.pets.data.repository.CatsRepositoryImpl
import com.example.pets.domain.repository.CatsLocalRepository
import com.example.pets.domain.repository.CatsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { CatBreedMapper() }

    single { AppDataBase.create(androidApplication()) }

    factory<CatsRepository> { CatsRepositoryImpl(get(), get()) }
    factory<CatsLocalRepository> { CatsLocalRepositoryImpl(get()) }

}
