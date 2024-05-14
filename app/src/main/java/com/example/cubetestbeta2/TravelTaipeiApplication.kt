package com.example.cubetestbeta2

import android.app.Application
import com.example.cubetestbeta2.di.appModule
import com.example.cubetestbeta2.di.viewModelModule
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
