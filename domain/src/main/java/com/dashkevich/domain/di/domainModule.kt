package com.dashkevich.domain.di

import com.dashkevich.domain.repository.LocalDBRepository
import com.dashkevich.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductRepository(get()) }
    single { LocalDBRepository(get()) }
}


val domainModule = module { includes(repositoryModule) }