package com.app.arbitragemcripto.fragments.service.exchanges.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.api.RetrofitClient
import com.app.arbitragemcripto.fragments.service.dto.DetailCotacaoArbitragemDto
import com.app.arbitragemcripto.fragments.service.model.mercadobitcoin.MercadoBitcoinModel
import com.app.arbitragemcripto.fragments.service.model.novadax.NovaDaxModel
import retrofit2.Call
import retrofit2.Response

class NovadaxService {

    val api = RetrofitClient.makeNovaDaxApi()
    lateinit var response : Call<NovaDaxModel>
    lateinit var call: Response<NovaDaxModel>
    lateinit var model : NovaDaxModel

    fun getCotacaoBitcoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinLast(): Double{
        response = api.getCotacaoBitcoin()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }

    fun getCotacaoBitcoinCash(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }

    fun getCotacaoBitcoinCashLast(): Double{
        response = api.getCotacaoBitcoinCash()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }

    fun getCotacaoLitecoin(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }

    fun getCotacaoLitecoinLast(): Double{
        response = api.getCotacaoLitecoin()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }

    fun getCotacaoRipple(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }

    fun getCotacaoRippleLast(): Double{
        response = api.getCotacaoRipple()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }


    fun getCotacaoEthereum(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }

    fun getCotacaoEthereumLast(): Double{
        response = api.getCotacaoEthereum()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }


    fun getCotacaoDash(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoDash()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }


    fun getCotacaoDashLast(): Double{
        response = api.getCotacaoDash()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }

    fun getCotacaoChainLink(): DetailCotacaoArbitragemDto {
        response = api.getCotacaoChainLink()
        call = response.execute()
        model = call.body()!!
        var dto = DetailCotacaoArbitragemDto(ExchangeEnum.NOVADAX.getIdentificador()!!,  model.data?.bid!!.toDouble(), model.data?.ask!!.toDouble())
        return dto
    }

    fun getCotacaoChainLinkLast(): Double{
        response = api.getCotacaoChainLink()
        call = response.execute()
        model = call.body()!!
        return model.data?.lastPrice!!.toDouble()
    }
}