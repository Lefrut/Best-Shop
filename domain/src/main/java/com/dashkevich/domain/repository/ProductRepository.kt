package com.dashkevich.domain.repository

import com.dashkevich.dat.api.ProductService
import com.dashkevich.dat.api.model.FlashSale
import com.dashkevich.dat.api.model.Latest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class ProductRepository(private val productService: ProductService) {

    suspend fun getLatest(): Result<Latest> = runCatching {
        var value: Latest? = null
        productService.getLatest().buffer()
            .collect{
                value = it
            }
        value?.let {
            return@runCatching it
        }
        throw IllegalArgumentException("Value == null")
    }

    suspend fun getFlashSale(): Result<FlashSale> = runCatching {
        var value: FlashSale? = null
        productService.getFlashSale().buffer()
            .collect{
                value = it
            }
        value?.let {
            return@runCatching it
        }
        throw IllegalArgumentException("Value == null")
    }
}