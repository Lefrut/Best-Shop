package com.dashkevich.dat.api.model

import com.google.gson.annotations.SerializedName

data class FlashSale(
    @SerializedName("flash_sale")
    val flashSale: List<FlashSaleItem>
)