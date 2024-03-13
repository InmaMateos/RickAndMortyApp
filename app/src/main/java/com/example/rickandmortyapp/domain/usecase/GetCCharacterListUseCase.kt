package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.Repository
import javax.inject.Inject

class GetCCharacterListUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() = repository.getCharacters()
}