package com.dashkevich.home.page1.adapter.model

import com.dashkevich.utility.adapter.Item

class FlashSaleUI(
    val category: String,
    val title: String,
    val price: Double,
    val discount: Int,
    val image: String
): Item {
}