package com.app.arbitragemcripto.fragments.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.service.dto.CreateArbitragemDto
import com.app.arbitragemcripto.fragments.service.dto.DetailCotacaoArbitragemDto
import com.app.arbitragemcripto.fragments.service.dto.ResponseArbitragemCriptoMoedaDto
import com.app.arbitragemcripto.fragments.service.exchanges.service.*
import java.lang.NullPointerException
import java.util.*


class ArbitragemService {

    var mercadoBitcoinService = MercadoBitcoinService()
    var novadaxService = NovadaxService()
    var bitcointradeService = BitcoinTradeService()
    var bitcambioService = BitcambioService()
    var binanceService = BinanceService()
    var braziliexService = BraziliexService()

    fun loadAnalyzeAllCriptos(valorEntrada: String): ResponseArbitragemCriptoMoedaDto? {

        var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.BITCOIN.getRotulo(), valorEntrada)
        var responseBitcoin = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.LITECOIN.getRotulo(), valorEntrada)
        var responseLitecoin = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.BITCOIN_CASH.getRotulo(), valorEntrada)
        var responseBitcoinCash = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.ETHEREUM.getRotulo(), valorEntrada)
        var responseEthereum = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.RIPPLE.getRotulo(), valorEntrada)
        var responseRipple = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.DASH.getRotulo(), valorEntrada)
        var responseDash = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.TETHER.getRotulo(), valorEntrada)
        var responseTether = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.CHILIZ.getRotulo(), valorEntrada)
        var responseChiliz = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.CHAINLINK.getRotulo(), valorEntrada)
        var responseChainLink = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.PAXGOLD.getRotulo(), valorEntrada)
        var responsePaxGold = simulaExecucaoArbitragemCriptoMoeda(dtoCripto)

        var listaArbitragens = ArrayList<ResponseArbitragemCriptoMoedaDto>()

        if ( responseBitcoin != null) {
            listaArbitragens.add(responseBitcoin)
        }

        if ( responseLitecoin != null) {
            listaArbitragens.add(responseLitecoin);
        }

        if ( responseBitcoinCash != null) {
            listaArbitragens.add(responseBitcoinCash)
        }

        if ( responseBitcoinCash != null) {
            listaArbitragens.add(responseBitcoinCash)
        }

        if ( responseEthereum != null) {
            listaArbitragens.add(responseEthereum)
        }

        if ( responseRipple != null) {
            listaArbitragens.add(responseRipple)
        }

        if ( responseDash != null) {
            listaArbitragens.add(responseDash)
        }

        if ( responseTether != null) {
            listaArbitragens.add(responseTether)
        }

        if ( responseChiliz != null) {
            listaArbitragens.add(responseChiliz)
        }

        if ( responseChainLink != null) {
            listaArbitragens.add(responseChainLink)
        }

        if ( responsePaxGold != null) {
            listaArbitragens.add(responsePaxGold)
        }

        var lista = listaArbitragens.sortedBy { it.valorLucro }

        try{
            return lista!!.last()
        }
        catch(ex: Exception){

        }
        return null
    }

    private fun simulaExecucaoArbitragemCriptoMoeda(dto: CreateArbitragemDto): ResponseArbitragemCriptoMoedaDto? {

        if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.BITCOIN.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                                                    mercadoBitcoinService.getCotacaoBitcoin(),
                                                    novadaxService.getCotacaoBitcoin(),
                                                    bitcointradeService.getCotacaoBitcoin(),
                                                    braziliexService.getCotacaoBitcoin()
                                        )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.BITCOIN_CASH.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoBitcoinCash(),
                novadaxService.getCotacaoBitcoinCash(),
                bitcointradeService.getCotacaoBitcoinCash(),
                braziliexService.getCotacaoBitcoinCash()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.LITECOIN.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoLitecoin(),
                novadaxService.getCotacaoLitecoin(),
                bitcointradeService.getCotacaoLitecoin(),
               // binanceService.getCotacaoLitecoin(),
                braziliexService.getCotacaoLitecoin()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.RIPPLE.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoRipple(),
                novadaxService.getCotacaoRipple(),
                bitcointradeService.getCotacaoRipple(),
              //  binanceService.getCotacaoRipple(),
                braziliexService.getCotacaoRipple()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.DASH.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                novadaxService.getCotacaoDash(),
                braziliexService.getCotacaoDash()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.ETHEREUM.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoEthereum(),
                novadaxService.getCotacaoEthereum(),
                bitcointradeService.getCotacaoEthereum(),
              //  binanceService.getCotacaoEthereum(),
                braziliexService.getCotacaoEthereum()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.TETHER.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                binanceService.getCotacaoTether(),
                braziliexService.getCotacaoTether()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.CHILIZ.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoChiliz(),
                binanceService.getCotacaoChiliz()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.CHAINLINK.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoChainLink(),
                novadaxService.getCotacaoChainLink(),
                binanceService.getCotacaoChainLink()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }
        else if (dto.criptoMoedaSelecionada.equals(CriptoMoedaEnum.PAXGOLD.getRotulo())){
            var listaCotacoes: List<DetailCotacaoArbitragemDto>  = Arrays.asList<DetailCotacaoArbitragemDto>(
                mercadoBitcoinService.getCotacaoPaxGold(),
                braziliexService.getCotacaoPaxGold()
            )

            return loadInfoExecArbitragem(listaCotacoes, dto)
        }

        return null
    }

    private fun loadInfoExecArbitragem(listaCotacoes: List<DetailCotacaoArbitragemDto>, dto: CreateArbitragemDto): ResponseArbitragemCriptoMoedaDto? {

        var cotacaoCompra: DetailCotacaoArbitragemDto? = null
        var cotacaoVenda: DetailCotacaoArbitragemDto? = null

        try{
            var lista = listaCotacoes.sortedBy { it.valorCotacaoCompra }
            cotacaoCompra = lista.first()
            if ( cotacaoCompra != null){
                var quantCripto = dto.valorEntrada?.toDouble()?.div(cotacaoCompra.valorCotacaoCompra!!)
                lista = listaCotacoes.sortedBy { it.valorCotacaoVenda }
                cotacaoVenda = lista.last()

                val valorVenda = cotacaoVenda.valorCotacaoVenda!! * quantCripto!!
                val lucroBruto: Double = valorVenda - dto.valorEntrada!!.toDouble()
                val response = ResponseArbitragemCriptoMoedaDto(dto.criptoMoedaSelecionada,
                    cotacaoCompra.nomeExchange,
                    cotacaoCompra.valorCotacaoCompra,
                    cotacaoVenda.nomeExchange,
                    cotacaoVenda.valorCotacaoVenda,
                    0.toDouble(),
                    lucroBruto,
                    quantCripto)

                return response
            }
            return null
        }
        catch(ex1: NullPointerException){
            return null
        }
        catch(ex2: Exception){
            return null
        }

    }

    fun loadAnalyzeByCripto(valorEntrada: String, cripto: String): ResponseArbitragemCriptoMoedaDto? {

        if (cripto.equals(CriptoMoedaEnum.BITCOIN.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.BITCOIN.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.BITCOIN_CASH.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.BITCOIN_CASH.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.LITECOIN.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.LITECOIN.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.RIPPLE.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.RIPPLE.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.DASH.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.DASH.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.ETHEREUM.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.ETHEREUM.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.TETHER.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.TETHER.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.CHILIZ.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.CHILIZ.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.CHAINLINK.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.CHAINLINK.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }
        else if (cripto.equals(CriptoMoedaEnum.PAXGOLD.getRotulo())){
            var dtoCripto = CreateArbitragemDto(CriptoMoedaEnum.PAXGOLD.getRotulo(), valorEntrada)
            return simulaExecucaoArbitragemCriptoMoeda(dtoCripto)
        }

        return null
    }
}