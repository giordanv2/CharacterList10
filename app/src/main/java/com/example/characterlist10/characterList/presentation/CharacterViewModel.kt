package com.example.characterlist10.characterList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.characterList.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharacterListState(
    val isLoading: Boolean = false,
    val characterList: List<Character> = emptyList(),
    val errorMessage: String? = null
)

@HiltViewModel
class CharacterViewModel @Inject constructor (

    private val characterRepository: CharacterRepository

): ViewModel() {

    private val _state = MutableStateFlow(CharacterListState())
    val state: StateFlow<CharacterListState> get() = _state

    fun getAllCharacters() {
        _state.update { it.copy(isLoading = true) }
        try {
            viewModelScope.launch {
                val characters = characterRepository.getAllCharacters()
                _state.update { it.copy(
                    isLoading = false,
                    characterList = characters,
                ) }
            }
        } catch (e: Exception) {
            _state.update { it.copy(
                isLoading = false,
                errorMessage = e.localizedMessage ?: "Unknown error"
            ) }
        }
    }
}