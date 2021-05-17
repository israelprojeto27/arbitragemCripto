package com.app.arbitragemcripto.fragments.service.api

import com.app.arbitragemcripto.fragments.service.exchanges.api.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private val httpClient = OkHttpClient.Builder()

    fun makeMercadoBitcoinApi(): MercadoBitcoinApi {
        return Retrofit.Builder()
            .baseUrl(MercadoBitcoinApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(MercadoBitcoinApi::class.java)
    }

    fun makeNovaDaxApi(): NovadaxApi {
        return Retrofit.Builder()
            .baseUrl(NovadaxApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(NovadaxApi::class.java)
    }

    fun makeBinanceApi(): BinanceApi {
        return Retrofit.Builder()
            .baseUrl(BinanceApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(BinanceApi::class.java)
    }

    fun makeBraziliexApi(): BraziliexApi {
        return Retrofit.Builder()
            .baseUrl(BraziliexApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(BraziliexApi::class.java)
    }

    fun makeBitcambioApi(): BitcambioApi {
        return Retrofit.Builder()
            .baseUrl(BitcambioApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(BitcambioApi::class.java)
    }

    fun makeBitcointradeApi(): BitcointradeApi {
        return Retrofit.Builder()
            .baseUrl(BitcointradeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build().create(BitcointradeApi::class.java)
    }



}