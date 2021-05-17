package com.app.arbitragemcripto.fragments.service.exchanges.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.api.RetrofitClient
import com.app.arbitragemcripto.fragments.service.dto.DetailCotacaoArbitragemDto
import com.app.arbitragemcripto.fragments.service.model.bitcointrade.BitcoinTradeModel
import retrofit2.Call
import retrofit2.Response

class BitcoinTradeService {

    val api = RetrofitClient.makeBitcointradeApi()
    lateinit var response : Call<BitcoinTradeModel>
    lateinit var call: Response<BitcoinTradeModel>
    lateinit var model : BitcoinTradeModel



    fun getCotacaoBitcoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BITCOIN_TRADE.getIdentificador()!!,  model.data?.buy!!.toDouble(), model.data?.buy!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinLast(): Double{
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        return model.data?.last!!.toDouble()
    }

    fun getCotacaoLitecoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BITCOIN_TRADE.getIdentificador()!!,  model.data?.buy!!.toDouble(), model.data?.buy!!.toDouble())
        return dto
    }

    fun getCotacaoLitecoinLast(): Double{
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        return model.data?.last!!.toDouble()
    }

    fun getCotacaoEthereum(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BITCOIN_TRADE.getIdentificador()!!,  model.data?.buy!!.toDouble(), model.data?.buy!!.toDouble())
        return dto
    }

    fun getCotacaoEthereumLast(): Double{
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        return model.data?.last!!.toDouble()
    }

    fun getCotacaoRipple(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BITCOIN_TRADE.getIdentificador()!!,  model.data?.buy!!.toDouble(), model.data?.buy!!.toDouble())
        return dto
    }

    fun getCotacaoRippleLast(): Double{
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        return model.data?.last!!.toDouble()
    }

    fun getCotacaoBitcoinCash(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BITCOIN_TRADE.getIdentificador()!!,  model.data?.buy!!.toDouble(), model.data?.buy!!.toDouble())
        return dto
    }


    fun getCotacaoBitcoinCashLast(): Double{
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        return model.data?.last!!.toDouble()
    }
}