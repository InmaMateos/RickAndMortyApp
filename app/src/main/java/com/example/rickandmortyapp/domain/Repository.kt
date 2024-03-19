package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.domain.model.CharacterModel
import com.example.rickandmortyapp.domain.model.ResultModel

interface Repository {
    suspend fun getCharacters(): CharacterModel?

    suspend fun getCharacterById(id: Int): ResultModel ?
}