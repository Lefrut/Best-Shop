package com.dashkevich.domain.repository

import com.dashkevich.dat.api.ProductService
import com.dashkevich.dat.api.model.FlashSale
import com.dashkevich.dat.api.model.Latest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
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
        throw IllegalArgumentException("Data didn't sign up")

    }

    private suspend fun getLatest(): Latest {
        return productService.getLatest()
    }

    private suspend fun getFlashSale(): FlashSale {
        return productService.getFlashSale()
    }
}