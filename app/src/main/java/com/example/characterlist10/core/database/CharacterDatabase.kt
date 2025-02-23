package com.example.characterlist10.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.characterlist10.core.database.dao.CharacterDao
import com.example.characterlist10.core.database.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class CharacterDatabase: RoomDatabase()  {
    abstract fun characterDao(): CharacterDao
}