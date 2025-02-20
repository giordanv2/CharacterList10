package com.example.characterlist10.characterList.data.dto

import com.example.characterlist10.characterList.domain.models.Character

data class CharacterResponse(
    val results: List<Character>
)