package com.example.rickandmortyapp.domain.model

import com.example.rickandmortyapp.data.network.response.Info
import com.example.rickandmortyapp.data.network.response.Result
import com.google.gson.annotations.SerializedName

data class CharacterModel (
     val info: Info,
     val results: List<ResultModel>
 )