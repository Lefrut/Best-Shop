package com.dashkevich.dat.di

import com.dashkevich.dat.api.ProductService
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://run.mocky.io/v3"

val retrofitModule = module {

    single<Converter.Factory> {
        GsonConverterFactory.create()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .build()
    }

    single<ProductService> {
        get<Retrofit>().create(ProductService::class.java)
    }

}

val dataModule = module { includes(retrofitModule) }