package com.example.rickandmortyapp.ui.list.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.model.ResultModel
import com.example.rickandmortyapp.domain.usecase.GetCCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel  @Inject constructor(private val getCCharacterListUseCase: GetCCharacterListUseCase): ViewModel() {

    private var _characters = MutableStateFlow<List<ResultModel>>(emptyList())
     val character:StateFlow<List<ResultModel>> = _characters

    fun getCharacters(){
        viewModelScope.launch {
            val characterList = getCCharacterListUseCase()
            if (characterList != null){
                withContext(Dispatchers.Main){
                    _characters.value = characterList.results
                }
            }
        }
    }

}