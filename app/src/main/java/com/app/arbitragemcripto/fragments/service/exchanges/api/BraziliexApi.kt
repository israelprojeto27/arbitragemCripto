package com.app.arbitragemcripto.fragments.service.exchanges.api

import com.app.arbitragemcripto.fragments.service.model.BraziliexModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface BraziliexApi {

    companion object {
        val BASE_URL = "https://braziliex.com/api/v1/public/"
        val URL_POST = "https://braziliex.com/api/v1/private"
        val TAXA_TRANSACAO = 0.005
    }

    @GET("ticker/btc_brl")
    fun getCotacaoBitcoin(): Call<BraziliexModel>

    @GET("ticker/ltc_brl")
    fun getCotacaoLitecoin(): Call<BraziliexModel>

    @GET("ticker/bch_brl")
    fun getCotacaoBitcoinCash(): Call<BraziliexModel>

    @GET("ticker/xrp_brl")
    fun getCotacaoRipple(): Call<BraziliexModel>

    @GET("ticker/eth_brl")
    fun getCotacaoEthereum(): Call<BraziliexModel>

    @GET("ticker/dash_brl")
    fun getCotacaoDash(): Call<BraziliexModel>

    @GET("ticker/usdt_brl")
    fun getCotacaoTether(): Call<BraziliexModel>

    @GET("ticker/paxg_brl")
    fun getCotacaoPaxGold(): Call<BraziliexModel>



    @POST("open_orders")
    fun createOrder(): Call<BraziliexModel>
}