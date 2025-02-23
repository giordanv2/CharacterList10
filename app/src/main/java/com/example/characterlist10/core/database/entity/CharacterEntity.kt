package com.example.characterlist10.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
class CharacterEntity(
    @PrimaryKey val id: String,
    val name: String,
    val status: String,
    val image: String
)