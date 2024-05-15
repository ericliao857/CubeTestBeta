package com.example.cubetest.repository

import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    suspend fun saveLanguageCode(languageCode: String)
    fun getLanguageCode(): String

    fun getLanguageFlow(): Flow<String>
}