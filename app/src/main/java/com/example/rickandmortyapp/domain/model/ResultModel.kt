package com.example.rickandmortyapp.domain.model

import com.example.rickandmortyapp.data.network.response.Location
import com.example.rickandmortyapp.data.network.response.Origin
import com.google.gson.annotations.SerializedName

data class ResultModel (
    val created : String,
    val episode : List<String?>,
    val gender : String,
    val id : Int,
    val image : String,
    val location : Location,
    val name : String,
    val origin : Origin,
    val species : String,
    val status : String,
    val type : String,
    val url : String
)
