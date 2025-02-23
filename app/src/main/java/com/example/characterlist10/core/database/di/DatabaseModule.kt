package com.example.characterlist10.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.characterlist10.core.database.CharacterDatabase
import com.example.characterlist10.core.database.dao.CharacterDao
import com.example.characterlist10.core.database.entity.CharacterEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = CharacterDatabase::class.java,
            name = "character_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
        return characterDatabase.characterDao()
    }
}