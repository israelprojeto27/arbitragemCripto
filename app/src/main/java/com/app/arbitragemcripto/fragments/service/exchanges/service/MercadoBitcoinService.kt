package com.app.arbitragemcripto.fragments.service.exchanges.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.api.RetrofitClient
import com.app.arbitragemcripto.fragments.service.dto.DetailCotacaoArbitragemDto
import com.app.arbitragemcripto.fragments.service.model.mercadobitcoin.MercadoBitcoinModel
import retrofit2.Call
import retrofit2.Response


class MercadoBitcoinService  {
    val api = RetrofitClient.makeMercadoBitcoinApi()
    lateinit var response : Call<MercadoBitcoinModel>
    lateinit var call: Response<MercadoBitcoinModel>
    lateinit var model : MercadoBitcoinModel

    fun getCotacaoBitcoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinLast(): Double{
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }

    fun getCotacaoLitecoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoLitecoinLast(): Double{
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }

    fun getCotacaoBitcoinCash(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinCashLast(): Double{
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }

    fun getCotacaoRipple(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoRippleLast(): Double{
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }

    fun getCotacaoEthereum(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoEthereumLast(): Double{
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }

    fun getCotacaoChiliz(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoChiliz()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoChilizLast(): Double{
        response = api.getCotacaoChiliz()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }

    fun getCotacaoChainLink(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoChainLink()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoChainLinkLast(): Double{
        response = api.getCotacaoChainLink()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble()
    }


    fun getCotacaoPaxGold(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoPaxGold()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.MERCADO_BITCOIN.getIdentificador()!!,  model.ticker?.buy!!.toDouble(), model.ticker?.sell!!.toDouble())
        return dto
    }

    fun getCotacaoPaxGoldLast(): Double{
        response = api.getCotacaoPaxGold()
        call = response.execute()
        model = call.body()!!
        return model.ticker?.last!!.toDouble().toDouble()
    }

}