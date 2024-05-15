package com.example.cubetest.data

import com.example.cubetest.vo.ApiBean
import com.example.cubetest.vo.attraction.Attraction
import com.example.cubetest.vo.news.News
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @GET("{lang}/Attractions/All")
    @Headers("Accept: application/json")
    suspend fun getAttractions(@Path("lang") lang: String): ApiBean<List<Attraction>>

    @GET("{lang}/Events/News")
    @Headers("Accept: application/json")
    suspend fun getNews(@Path("lang") lang: String): ApiBean<List<News>>


    companion object {
        const val DOMAIN = "https://www.travel.taipei/open-api/"
    }
}