package com.app.arbitragemcripto.fragments.service.exchanges.api

import com.app.arbitragemcripto.fragments.service.model.BinanceModel
import retrofit2.Call
import retrofit2.http.GET


interface BinanceApi {

    companion object {
        val BASE_URL = "https://api.binance.com/api/v3/"
    }

    @GET("ticker/24hr?symbol=BTCBRL")
    fun getCotacaoBitcoin(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=BCHBRL")
    fun getCotacaoBitcoinCash(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=LTCBRL")
    fun getCotacaoLitecoin(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=ETHBRL")
    fun getCotacaoEthereum(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=XRPBRL")
    fun getCotacaoRipple(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=USDTBRL")
    fun getCotacaoTether(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=CHZBRL")
    fun getCotacaoChiliz(): Call<BinanceModel>

    @GET("ticker/24hr?symbol=LINKBRL")
    fun getCotacaoChainLink(): Call<BinanceModel>
}