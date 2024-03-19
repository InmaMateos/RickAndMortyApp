package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.data.network.response.Result
import com.example.rickandmortyapp.data.network.response.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): RickAndMortyResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : Result
}