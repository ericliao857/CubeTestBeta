package com.example.cubetestbeta2.di

import com.example.cubetestbeta2.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainViewModel)
}