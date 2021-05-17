package com.app.arbitragemcripto.fragments.service.exchanges.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.api.RetrofitClient
import com.app.arbitragemcripto.fragments.service.dto.DetailCotacaoArbitragemDto
import com.app.arbitragemcripto.fragments.service.model.BraziliexModel
import retrofit2.Call
import retrofit2.Response

class BraziliexService {

    val api = RetrofitClient.makeBraziliexApi()
    lateinit var response : Call<BraziliexModel>
    lateinit var call: Response<BraziliexModel>
    lateinit var model : BraziliexModel

    fun getCotacaoBitcoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinLast(): Double{
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }

    fun getCotacaoLitecoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoLitecoinLast(): Double{
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }

    fun getCotacaoBitcoinCash(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinCashLast(): Double{
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }

    fun getCotacaoRipple(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoRippleLast(): Double{
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }

    fun getCotacaoEthereum(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoEthereumLast(): Double{
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }


    fun getCotacaoDash(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoDash()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }


    fun getCotacaoDashLast(): Double{
        response = api.getCotacaoDash()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }

    fun getCotacaoTether(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoTether()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoTetherLast(): Double{
        response = api.getCotacaoTether()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }


    fun getCotacaoPaxGold(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoPaxGold()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.BRAZILIEX.getIdentificador()!!,  model.lowestAsk!!.toDouble(), model.highestBid!!.toDouble())
        return dto
    }

    fun getCotacaoPaxGoldLast(): Double{
        response = api.getCotacaoPaxGold()
        call = response.execute()
        model = call.body()!!
        return model.last!!.toDouble()
    }

}