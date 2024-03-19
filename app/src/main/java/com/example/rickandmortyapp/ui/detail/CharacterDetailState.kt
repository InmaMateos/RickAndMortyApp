package com.example.rickandmortyapp.ui.detail

import com.example.rickandmortyapp.domain.model.CharacterModel
import com.example.rickandmortyapp.domain.model.ResultModel

sealed class CharacterDetailState {

     data object Loading : CharacterDetailState()

     data class Error(val message: String) : CharacterDetailState()
     data class Success(val character: ResultModel) : CharacterDetailState()
}