package com.app.arbitragemcripto.fragments.service.model

data class BinanceModel (
    val symbol: String? = null,
    val priceChange: String? = null,
    val priceChangePercent: String? = null,
    val weightedAvgPrice: String? = null,
    val prevClosePrice: String? = null,
    val lastPrice: String? = null,
    val lastQty: String? = null,
    val bidPrice: String? = null,
    val bidQty: String? = null,
    val askPrice: String? = null,
    val askQty: String? = null,
    val openPrice: String? = null,
    val highPrice: String? = null,
    val lowPrice: String? = null,
    val volume: String? = null,
    val quoteVolume: String? = null,
    val openTime: Long? = null,
    val closeTime: Long? = null,
    val firstId: Long? = null,
    val lastId: Long? = null,
    val count: Long? = null
)