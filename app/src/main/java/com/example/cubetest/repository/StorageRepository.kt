package com.example.cubetest.repository

interface StorageRepository {
    suspend fun saveLanguageCode(languageCode: String)
    fun getLanguageCode(): String
}