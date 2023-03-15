package com.dashkevich.home.page1.adapter.model

import com.dashkevich.utility.adapter.Item

class FlashSaleUI(
    val category: String,
    val title: String,
    val price: Int,
    val discount: Int,
    val image: String
): Item {
}