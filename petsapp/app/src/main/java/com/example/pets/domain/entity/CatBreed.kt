package com.example.pets.domain.entity

class CatBreed(
    var id: String,
    var name: String,
    var temperament: String,
    var description: String,
    var origin: String,
    var country_code: String,
    var image: CatImage?,
    var isFavorite: Boolean = false

)
