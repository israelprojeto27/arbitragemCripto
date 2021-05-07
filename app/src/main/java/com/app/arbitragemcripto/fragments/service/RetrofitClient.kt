package com.app.arbitragemcripto.fragments.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://10.0.2.2:8080/"
    private const val BASE_URL_ARBITRAGEM = BASE_URL + "arbitragem/"
    private const val BASE_URL_COTACAO = BASE_URL + "cotacao/"

    val arbitragemApi: ArbitragemApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_ARBITRAGEM)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ArbitragemApi::class.java)
    }


    val cotacaoApi: CotacaoApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_COTACAO)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CotacaoApi::class.java)
    }
}