package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getCharacters(): CharacterModel?
}