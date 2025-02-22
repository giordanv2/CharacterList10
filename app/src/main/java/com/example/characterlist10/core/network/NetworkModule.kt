package com.example.characterlist10.core.network

import com.example.characterlist10.characterList.data.repository.CharacterRepositoryImpl
import com.example.characterlist10.characterList.data.responses.CharacterApi
import com.example.characterlist10.characterList.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}