package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.data.network.response.RickAndMortyResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): RickAndMortyResponse
}