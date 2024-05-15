package com.example.cubetest.repository

import com.example.cubetest.vo.ApiBean
import com.example.cubetest.vo.attraction.Attraction
import com.example.cubetest.vo.news.News
import kotlinx.coroutines.flow.Flow

interface TravelTaipeiRepository {
    fun fetchAttractions(lang: String): Flow<ApiBean<List<Attraction>>>
    fun fetchNews(lang: String): Flow<ApiBean<List<News>>>
}