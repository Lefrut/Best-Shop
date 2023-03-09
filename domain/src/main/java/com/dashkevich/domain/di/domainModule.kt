package com.dashkevich.domain.di

import com.dashkevich.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductRepository(get()) }
}


val domainModule = module { includes(repositoryModule) }