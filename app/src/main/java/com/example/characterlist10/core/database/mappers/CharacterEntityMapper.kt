package com.example.characterlist10.core.database.mappers

import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.core.database.entity.CharacterEntity

fun CharacterEntity.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        image = image
    )
}

fun Character.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        image = image
    )
}