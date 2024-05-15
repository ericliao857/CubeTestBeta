package com.example.cubetestbeta2.repository

import com.example.cubetestbeta2.vo.ApiBean
import com.example.cubetestbeta2.vo.attraction.Attraction
import com.example.cubetestbeta2.vo.news.News
import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    suspend fun saveLanguageCode(languageCode: String)
    fun getLanguageCode(): String
}