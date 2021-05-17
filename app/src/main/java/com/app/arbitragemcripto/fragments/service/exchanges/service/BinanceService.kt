package com.app.arbitragemcripto.fragments.service.exchanges.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.api.RetrofitClient
import com.app.arbitragemcripto.fragments.service.dto.DetailCotacaoArbitragemDto
import com.app.arbitragemcripto.fragments.service.model.BinanceModel
import retrofit2.Call
import retrofit2.Response

class BinanceService {

    val api = RetrofitClient.makeBinanceApi()
    lateinit var response : Call<BinanceModel>
    lateinit var call: Response<BinanceModel>
    lateinit var model : BinanceModel

    fun getCotacaoBitcoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinLast(): Double{
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }

    fun getCotacaoLitecoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoLitecoinLast(): Double{
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }

    fun getCotacaoEthereum(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoEthereumLast(): Double{
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }

    fun getCotacaoRipple(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoRippleLast(): Double{
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }

    fun getCotacaoTether(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoTether()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoTetherLast(): Double{
        response = api.getCotacaoTether()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }

    fun getCotacaoChiliz(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoChiliz()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoChilizLast(): Double{
        response = api.getCotacaoChiliz()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }


    fun getCotacaoChainLink(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoChainLink()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BINANCE.getIdentificador()!!,  model.askPrice!!.toDouble(), model.bidPrice!!.toDouble())
        return dto
    }

    fun getCotacaoChainLinkLast(): Double{
        response = api.getCotacaoChainLink()
        call = response.execute()
        model = call.body()!!
        return model.lastPrice!!.toDouble()
    }

}