package com.example.cubetest.repository

import com.example.cubetest.data.ApiService
import com.example.cubetest.vo.ApiBean
import com.example.cubetest.vo.attraction.Attraction
import com.example.cubetest.vo.news.News
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TravelTaipeiRepositoryImpl(
    private val apiService: ApiService,
    private val iODispatcher: CoroutineDispatcher = Dispatchers.IO
): TravelTaipeiRepository {
    override fun fetchAttractions(lang: String): Flow<ApiBean<List<Attraction>>> {
        return flow {
            emit(
                apiService.getAttractions(lang)
            )
        }.flowOn(iODispatcher)
    }

    override fun fetchNews(lang: String): Flow<ApiBean<List<News>>> {
        return flow {
            emit(
                apiService.getNews(lang)
            )
        }.flowOn(iODispatcher)
    }
}