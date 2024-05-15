package com.example.cubetest

import android.app.Application
import com.example.cubetest.di.appModule
import com.example.cubetest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TravelTaipeiApplication: Application () {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@TravelTaipeiApplication)
            modules(
                listOf(
                    appModule,
                    viewModelModule
                )
            )
        }
    }
}
