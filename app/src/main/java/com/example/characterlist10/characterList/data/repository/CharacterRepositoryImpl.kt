package com.example.characterlist10.characterList.data.repository

import com.example.characterlist10.characterList.data.responses.CharacterApi
import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.characterList.domain.repository.CharacterRepository
import com.example.characterlist10.core.database.dao.CharacterDao
import com.example.characterlist10.core.database.mappers.toCharacter
import com.example.characterlist10.core.database.mappers.toEntity
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(

    private val characterApi: CharacterApi,
    private val characterDao: CharacterDao

) : CharacterRepository {

    override suspend fun getAllCharacters(): List<Character> {
        val cachedCharacters = characterDao.getAllCharacters()
        return if (cachedCharacters.isNotEmpty()) {
            cachedCharacters.map { it.toCharacter() }
        } else {
            val characters = characterApi.getAllCharacters().results
            characterDao.insertAllCharacters(characters.map { it.toEntity() })
            characters
        }
    }

    override suspend fun addFavorite(character: Character) {
        characterDao.insertCharacter(character.toEntity())
    }

    override suspend fun removeFavorite(id: String) {
        characterDao.deleteCharacterById(id)
    }
}