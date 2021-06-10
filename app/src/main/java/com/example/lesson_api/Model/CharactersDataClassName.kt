package com.example.lesson_api.Model

data class CharactersDataClassName(
    var created: String,
    var episode: List<String>,
    var gender: String,
    var id: Int,
    var image: String,
    var location: LocationX,
    var name: String,
    var origin: OriginX,
    var species: String,
    var status: String,
    var type: String,
    var url: String
)