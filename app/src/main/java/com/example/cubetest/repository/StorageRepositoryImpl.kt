package com.example.cubetest.repository

import com.example.cubetest.data.SharedPreferences
import com.example.cubetest.vo.Language
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StorageRepositoryImpl(
    private val sharedPreferences: SharedPreferences,
    private val iODispatcher: CoroutineDispatcher = Dispatchers.IO
): StorageRepository {

    override suspend fun saveLanguageCode(languageCode: String) {
        withContext(iODispatcher) {
            sharedPreferences.saveLanguage(languageCode)
        }
    }

    override fun getLanguageCode(): String {
        return sharedPreferences.getLanguage() ?: Language.ZH_TW.languageCode
    }
}