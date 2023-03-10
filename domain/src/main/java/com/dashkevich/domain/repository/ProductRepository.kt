package com.dashkevich.domain.repository

import com.dashkevich.dat.api.ProductService
import com.dashkevich.dat.api.model.FlashSale
import com.dashkevich.dat.api.model.Latest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch

class ProductRepository(private val productService: ProductService) {

    suspend fun getData(scope: CoroutineScope): Result<Pair<Latest, FlashSale>> = runCatching {
        var data: Pair<Latest, FlashSale>? = null
        val job = scope.launch {
            val latest = async { getLatest() }
            val flashSale = async { getFlashSale() }
            data = Pair(latest.await(), flashSale.await())
        }
        job.join()
        data?.let {
            return@runCatching it
        }
        throw IllegalArgumentException("All data didn't sign up")
    }

    private suspend fun getLatest(): Latest {
        var value: Latest? = null
        productService.getLatest().buffer()
            .collect{
                value = it
            }

        if(value!=null) return value as Latest
        else throw IllegalArgumentException("Latest didn't sign up")
    }

    private suspend fun getFlashSale(): FlashSale {
        var value: FlashSale? = null
        productService.getFlashSale().buffer()
            .collect{
                value = it
            }
        if(value!=null) return value as FlashSale
        throw IllegalArgumentException("Flash sale didn't sign up")
    }

}