package com.example.characterlist10.characterList.data.repository

import com.example.characterlist10.characterList.data.responses.CharacterApi
import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.characterList.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(

    private val characterApi: CharacterApi,

) : CharacterRepository {

    override suspend fun getAllCharacters(): List<Character> {
        return characterApi.getAllCharacters().results
    }
}