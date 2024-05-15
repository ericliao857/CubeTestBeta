package com.example.cubetestbeta2.di

import android.content.Context
import com.example.cubetestbeta2.data.ApiService
import com.example.cubetestbeta2.data.SharedPreferences
import com.example.cubetestbeta2.repository.StorageRepository
import com.example.cubetestbeta2.repository.StorageRepositoryImpl
import com.example.cubetestbeta2.repository.TravelTaipeiRepository
import com.example.cubetestbeta2.repository.TravelTaipeiRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun providerOkHttp(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BASIC
    )
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
    return okHttpClient.build()
}

fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

fun provideRetrofit(
    gsonConverterFactory: GsonConverterFactory,
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(ApiService.DOMAIN)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

fun provideSharedPref(context: Context): SharedPreferences = SharedPreferences(context)

val appModule = module {
    single { providerOkHttp() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { provideService(get()) }
    single { provideSharedPref(get()) }
    single<TravelTaipeiRepository> { TravelTaipeiRepositoryImpl(get()) }
    single<StorageRepository> { StorageRepositoryImpl(get()) }
}