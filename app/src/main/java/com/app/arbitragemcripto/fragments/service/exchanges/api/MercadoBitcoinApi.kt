package com.app.arbitragemcripto.fragments.service.exchanges.api

import com.app.arbitragemcripto.fragments.service.model.mercadobitcoin.MercadoBitcoinModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

@Suppress("SpellCheckingInspection")
interface MercadoBitcoinApi {

    companion object {
        val BASE_URL = "https://www.mercadobitcoin.net/api/"
        val TAXA_OPERACAO = 0.007
    }

    @GET("BTC/ticker")
    fun getCotacaoBitcoin(): Call<MercadoBitcoinModel>

    @GET("LTC/ticker")
    fun getCotacaoLitecoin(): Call<MercadoBitcoinModel>

    @GET("BCH/ticker")
    fun getCotacaoBitcoinCash(): Call<MercadoBitcoinModel>

    @GET("XRP/ticker")
    fun getCotacaoRipple(): Call<MercadoBitcoinModel>

    @GET("ETH/ticker")
    fun getCotacaoEthereum(): Call<MercadoBitcoinModel>

    @GET("CHZ/ticker")
    fun getCotacaoChiliz() : Call<MercadoBitcoinModel>

    @GET("LINK/ticker")
    fun getCotacaoChainLink() : Call<MercadoBitcoinModel>

    @GET("PAXG/ticker")
    fun getCotacaoPaxGold() : Call<MercadoBitcoinModel>
}