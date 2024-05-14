package com.example.cubetestbeta2.di

import com.example.cubetestbeta2.repository.TravelTaipeiRepository
import com.example.cubetestbeta2.repository.TravelTaipeiRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single<TravelTaipeiRepository> { TravelTaipeiRepositoryImpl() }
}