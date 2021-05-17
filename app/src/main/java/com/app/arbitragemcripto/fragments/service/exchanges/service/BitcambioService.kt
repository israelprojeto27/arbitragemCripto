package com.app.arbitragemcripto.fragments.service.exchanges.service

import com.app.arbitragemcripto.fragments.service.api.RetrofitClient
import com.app.arbitragemcripto.fragments.service.model.BitcambioModel
import retrofit2.Call
import retrofit2.Response

class BitcambioService {

    val api = RetrofitClient.makeBitcambioApi()
    lateinit var response : Call<BitcambioModel>
    lateinit var call: Response<BitcambioModel>
    lateinit var model : BitcambioModel

    fun getCotacaoBitcoin(): Any? {
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        return model.last
    }
}