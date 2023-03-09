package com.dashkevich.dat.api

import com.dashkevich.dat.api.model.FlashSale
import com.dashkevich.dat.api.model.Latest
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


interface ProductService {

    @GET("/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    fun getLatest() : Flow<Latest>

    @GET("/a9ceeb6e-416d-4352-bde6-2203416576ac")
    fun getFlashSale() : Flow<FlashSale>

}