package com.dashkevich.home.di

import com.dashkevich.home.page1.Page1ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { Page1ViewModel(get()) }
}