package com.example.characterlist10.characterList.data.responses

import com.example.characterlist10.characterList.data.dto.CharacterResponse
import com.example.characterlist10.characterList.domain.models.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse
}