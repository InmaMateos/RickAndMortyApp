package com.example.rickandmortyapp.data

import android.util.Log
import com.example.rickandmortyapp.data.network.ApiService
import com.example.rickandmortyapp.data.network.response.toDomain
import com.example.rickandmortyapp.domain.Repository
import com.example.rickandmortyapp.domain.model.CharacterModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {

    override suspend fun getCharacters(): CharacterModel? {
        kotlin.runCatching { apiService.getCharacters() }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.e("inma", "Ha ocurrido un error:${it.message}") }
        return null
    }
}