package com.app.arbitragemcripto.fragments.service.exchanges.api

import com.app.arbitragemcripto.fragments.service.model.bitcointrade.BitcoinTradeModel
import retrofit2.Call
import retrofit2.http.GET

interface BitcointradeApi {

    companion object {
        val BASE_URL = "https://api.bitcointrade.com.br/v3/public/"
        val URL_POST = "https://api.bitcointrade.com.br/v3/market/"
        val TAXA_OPERACAO_EXECUTADA = 0.0025
        val TAXA_OPERACAO_EXECUTORA = 0.0075
    }
 
    @GET("BRLBTC/ticker")
    fun getCotacaoBitcoin(): Call<BitcoinTradeModel>

    @GET("BRLETH/ticker")
    fun getCotacaoEthereum(): Call<BitcoinTradeModel>

    @GET("BRLXRP/ticker")
    fun getCotacaoRipple(): Call<BitcoinTradeModel>

    @GET("BRLLTC/ticker")
    fun getCotacaoLitecoin(): Call<BitcoinTradeModel>

    @GET("BRLBCH/ticker")
    fun getCotacaoBitcoinCash(): Call<BitcoinTradeModel>

}