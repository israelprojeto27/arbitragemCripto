package com.app.arbitragemcripto.fragments.service.exchanges.api

import com.app.arbitragemcripto.fragments.service.model.BitcambioModel
import retrofit2.Call
import retrofit2.http.GET

interface BitcambioApi {

    companion object {
        val BASE_URL = "http://bitcambio_api.blinktrade.com/api/v1/BRL/"
        val TAXA_OPERACAO = 0.0099
    }

    @GET("ticker")
    fun getCotacaoBitcoin(): Call<BitcambioModel>
}