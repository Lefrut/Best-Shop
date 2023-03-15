package com.dashkevich.home.page1.model

import com.dashkevich.dat.api.model.FlashSale
import com.dashkevich.dat.api.model.Latest

data class Page1State(
    val latest: Latest = Latest(emptyList()),
    val flashSale: FlashSale = FlashSale(emptyList()),
    val screenStatus: ScreenStatus = ScreenStatus.Loading
)

enum class ScreenStatus {
    Success, Error, Loading, EmptyResult
}