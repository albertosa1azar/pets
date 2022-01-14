package com.example.pets.di

import com.example.pets.presentation.feature.pets.cats.CatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CatsViewModel(get()) }
}