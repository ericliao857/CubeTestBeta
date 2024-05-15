package com.example.cubetestbeta2.repository

import com.example.cubetestbeta2.vo.ApiBean
import com.example.cubetestbeta2.vo.attraction.Attraction
import com.example.cubetestbeta2.vo.news.News
import kotlinx.coroutines.flow.Flow

interface TravelTaipeiRepository {
    fun fetchAttractions(lang: String): Flow<ApiBean<List<Attraction>>>
    fun fetchNews(lang: String): Flow<ApiBean<List<News>>>
}