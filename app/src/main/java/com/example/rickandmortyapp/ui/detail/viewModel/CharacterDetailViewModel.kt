package com.example.rickandmortyapp.ui.detail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.usecase.GetCharacterDetailUseCase
import com.example.rickandmortyapp.ui.detail.CharacterDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val getCharacterDetailUseCase: GetCharacterDetailUseCase):ViewModel() {

    private val _state = MutableStateFlow<CharacterDetailState>(CharacterDetailState.Loading)
    val state: StateFlow<CharacterDetailState> = _state


    fun getCharacterDetail(id: Int){
        viewModelScope.launch {
            _state.value = CharacterDetailState.Loading
            val result = withContext(Dispatchers.IO){getCharacterDetailUseCase(id)}
            if (result != null){
                _state.value = CharacterDetailState.Success(result)
            }else{
                _state.value = CharacterDetailState.Error("Ha ocurrido un error")
            }

        }
    }

}