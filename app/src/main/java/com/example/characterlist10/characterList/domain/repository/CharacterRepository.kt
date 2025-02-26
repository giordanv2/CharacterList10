package com.example.characterlist10.characterList.domain.repository

import com.example.characterlist10.characterList.domain.models.Character

interface CharacterRepository {

    suspend fun getAllCharacters(): List<Character>

    suspend fun addFavorite(character: Character)

    suspend fun removeFavorite(id: String)
}