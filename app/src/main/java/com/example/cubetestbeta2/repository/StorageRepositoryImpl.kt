package com.example.cubetestbeta2.repository

import com.example.cubetestbeta2.data.SharedPreferences
import com.example.cubetestbeta2.vo.Language
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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