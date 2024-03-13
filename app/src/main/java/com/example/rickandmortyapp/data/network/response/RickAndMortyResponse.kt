package com.example.rickandmortyapp.data.network.response


import com.example.rickandmortyapp.domain.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<Result>
)

internal fun RickAndMortyResponse.toDomain() = CharacterModel(
    info = info,
    results = results.map { it.toDomain() }
)