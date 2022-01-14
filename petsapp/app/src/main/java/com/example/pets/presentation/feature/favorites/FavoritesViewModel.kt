package com.example.pets.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pets.data.database.entity.CatBreedEntity
import com.example.pets.domain.repository.CatsLocalRepository
import com.example.pets.domain.repository.CatsRepository
import com.example.pets.presentation.base.BaseViewModel

class FavoritesViewModel(
    private val catsRepository: CatsRepository,
    private val catsLocalRepository: CatsLocalRepository
) : BaseViewModel() {

    private val _cats = MutableLiveData<List<CatBreedEntity>>()
    val cats: LiveData<List<CatBreedEntity>> = _cats

    fun fetchLocalCats() {
        launch {
            val favoritedList = catsLocalRepository.getAll()
            _cats.postValue(favoritedList)

        }
    }

    fun setFavorite(cat: CatBreedEntity) {
        if (cat.isFavorite) catsLocalRepository.add(cat)
        else catsLocalRepository.remove(cat)
    }
}