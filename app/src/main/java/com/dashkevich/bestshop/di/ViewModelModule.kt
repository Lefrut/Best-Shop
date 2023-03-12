package com.dashkevich.bestshop.di

import com.dashkevich.entry.sign_in_page.SignInPageViewModel
import com.dashkevich.home.page1.Page1ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { Page1ViewModel(get()) }
    viewModel { SignInPageViewModel(get())}
}