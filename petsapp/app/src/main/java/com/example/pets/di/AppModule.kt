package com.example.pets.di

import org.koin.core.module.Module

val appModule: List<Module> = listOf(dataModule, presentationModule)