package com.app.arbitragemcripto.fragments.service.exchanges.api

import com.app.arbitragemcripto.fragments.service.model.novadax.NovaDaxModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NovadaxApi {

    companion object {
        val BASE_URL  = "https://api.novadax.com/v1/market/"
        val POST_URL  = "https://api.novadax.com/v1/orders/"
        val TAXA_OPERACAO  = 0.003
    }

    @GET("ticker?symbol=BTC_BRL")
    fun getCotacaoBitcoin(): Call<NovaDaxModel>

    @GET("ticker?symbol=BCH_BRL")
    fun getCotacaoBitcoinCash(): Call<NovaDaxModel>

    @GET("ticker?symbol=LTC_BRL")
    fun getCotacaoLitecoin(): Call<NovaDaxModel>

    @GET("ticker?symbol=XRP_BRL")
    fun getCotacaoRipple(): Call<NovaDaxModel>

    @GET("ticker?symbol=ETH_BRL")
    fun getCotacaoEthereum(): Call<NovaDaxModel>

    @GET("ticker?symbol=DASH_BRL")
    fun getCotacaoDash(): Call<NovaDaxModel>

    @GET("ticker?symbol=LINK_BRL")
    fun getCotacaoChainLink(): Call<NovaDaxModel>
}