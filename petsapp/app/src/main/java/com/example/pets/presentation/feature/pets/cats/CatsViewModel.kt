package com.example.pets.presentation.feature.pets.cats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pets.data.database.entity.CatBreedEntity
import com.example.pets.data.database.mapper.toEntity
import com.example.pets.domain.entity.CatBreed
import com.example.pets.domain.repository.CatsLocalRepository
import com.example.pets.domain.repository.CatsRepository
import com.example.pets.presentation.base.BaseViewModel

class CatsViewModel(
    private val catsRepository: CatsRepository,
    private val catsLocalRepository: CatsLocalRepository
) : BaseViewModel() {

    private val _cats = MutableLiveData<List<CatBreed>>()
    val cats: LiveData<List<CatBreed>> = _cats

    fun fetchCats() {
        launch {
            val catList = catsRepository.getCatBreed()
            val favoritedList = catsLocalRepository.getAll()
            setCatIsFavorite(catList,favoritedList)
            _cats.postValue(catList)
        }
    }

    private fun setCatIsFavorite(catsList: List<CatBreed>, favoritedList: List<CatBreedEntity>?) {
        val idList = favoritedList?.map { it.id }
        catsList.forEach{ cat ->
            if (idList != null) {
                cat.isFavorite = idList.contains(cat.id)
            }
        }
    }

    fun setFavorite(cat: CatBreed) {
        val catEntity = cat.toEntity()
        if (cat.isFavorite) catsLocalRepository.add(catEntity)
        else catsLocalRepository.remove(catEntity)
    }
}