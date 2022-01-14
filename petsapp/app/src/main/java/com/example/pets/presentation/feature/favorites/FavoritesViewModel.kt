package com.example.pets.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pets.domain.entity.CatBreed
import com.example.pets.domain.repository.CatsRepository
import com.example.pets.presentation.base.BaseViewModel

class FavoritesViewModel(
    private val catsRepository: CatsRepository,
) : BaseViewModel() {

    private val _cats = MutableLiveData<List<CatBreed>>()
    val cats: LiveData<List<CatBreed>> = _cats

    fun fetchCoffees() {
        launch {
            val catsList = catsRepository.getCatBreed()
            _cats.postValue(setCats(catsList))
        }

    }

    private fun setCats(repositoryList: List<CatBreed>): MutableList<CatBreed> {
        val catsList = mutableListOf<CatBreed>()

        repositoryList.forEach {
            catsList.add(it)
        }

        return catsList
    }

    fun setFavorite(catBreed: CatBreed) {
        TODO()
    }
}