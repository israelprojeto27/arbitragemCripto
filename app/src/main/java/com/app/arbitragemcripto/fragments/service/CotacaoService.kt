package com.app.arbitragemcripto.fragments.service

import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.dto.ResponseCriptoMoedasDto
import com.app.arbitragemcripto.fragments.service.dto.ResponseExchangeCriptoMoedaDto
import com.app.arbitragemcripto.fragments.service.exchanges.service.*

class CotacaoService {

    var mercadoBitcoinService = MercadoBitcoinService()
    var novadaxService = NovadaxService()
    var bitcointradeService = BitcoinTradeService()
    var bitcambioService = BitcambioService()
    var binanceService = BinanceService()
    var braziliexService = BraziliexService()

    fun loadCotacaoByCripto(cripto: String): ResponseExchangeCriptoMoedaDto? {

        if (cripto.equals(CriptoMoedaEnum.BITCOIN.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoBitcoinLast()
            response.valorCotacaoBitcoinTrade = bitcointradeService.getCotacaoBitcoinLast()
            response.valorCotacaoNovadax = novadaxService.getCotacaoBitcoinLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoBitcoinLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.BITCOIN_CASH.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoBitcoinCashLast()
            response.valorCotacaoBitcoinTrade = bitcointradeService.getCotacaoBitcoinCashLast()
            response.valorCotacaoNovadax = novadaxService.getCotacaoBitcoinCashLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoBitcoinCashLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.LITECOIN.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoLitecoinLast()
            response.valorCotacaoBitcoinTrade = bitcointradeService.getCotacaoLitecoinLast()
            response.valorCotacaoNovadax = novadaxService.getCotacaoLitecoinLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoLitecoinLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.RIPPLE.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoRippleLast()
            response.valorCotacaoBitcoinTrade = bitcointradeService.getCotacaoRippleLast()
            response.valorCotacaoNovadax = novadaxService.getCotacaoRippleLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoRippleLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.DASH.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoNovadax = novadaxService.getCotacaoDashLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoDashLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.ETHEREUM.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoEthereumLast()
            response.valorCotacaoBitcoinTrade = bitcointradeService.getCotacaoEthereumLast()
            response.valorCotacaoNovadax = novadaxService.getCotacaoEthereumLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoEthereumLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.TETHER.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoBinance = binanceService.getCotacaoTetherLast()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoTetherLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.CHILIZ.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoBinance = binanceService.getCotacaoChilizLast()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoChilizLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.CHAINLINK.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoBinance = binanceService.getCotacaoChainLinkLast()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoChainLinkLast()
            response.valorCotacaoNovadax = novadaxService.getCotacaoChainLinkLast()

            return response
        }
        else if (cripto.equals(CriptoMoedaEnum.PAXGOLD.getRotulo())){
            var response = ResponseExchangeCriptoMoedaDto()
            response.valorCotacaoBraziliex = braziliexService.getCotacaoPaxGoldLast()
            response.valorCotacaoMercadoBitcoin = mercadoBitcoinService.getCotacaoPaxGoldLast()

            return response
        }

        return null

    }

    fun loadCotacaoByExchange(exchange: String): ResponseCriptoMoedasDto? {

        if (exchange.equals(ExchangeEnum.MERCADO_BITCOIN.getRotulo())){
            var response = ResponseCriptoMoedasDto()
            response.valorCotacaoBitcoin = mercadoBitcoinService.getCotacaoBitcoinLast()
            response.valorCotacaoBitcoinCash = mercadoBitcoinService.getCotacaoBitcoinCashLast()
            response.valorCotacaoLitecoin = mercadoBitcoinService.getCotacaoLitecoinLast()
            response.valorCotacaoEthereum = mercadoBitcoinService.getCotacaoEthereumLast()
            response.valorCotacaoChainLink = mercadoBitcoinService.getCotacaoChainLinkLast()
            response.valorCotacaoChiliz = mercadoBitcoinService.getCotacaoChilizLast()
            response.valorCotacaoPaxGold = mercadoBitcoinService.getCotacaoPaxGoldLast()
            response.valorCotacaoRipple = mercadoBitcoinService.getCotacaoRippleLast()

            return response
        }
        else if (exchange.equals(ExchangeEnum.BITCOIN_TRADE.getRotulo())){
            var response = ResponseCriptoMoedasDto()
            response.valorCotacaoBitcoin = bitcointradeService.getCotacaoBitcoinLast()
            response.valorCotacaoBitcoinCash = bitcointradeService.getCotacaoBitcoinCashLast()
            response.valorCotacaoLitecoin = bitcointradeService.getCotacaoLitecoinLast()
            response.valorCotacaoEthereum = bitcointradeService.getCotacaoEthereumLast()
            response.valorCotacaoRipple = bitcointradeService.getCotacaoRippleLast()

            return response
        }
        else if (exchange.equals(ExchangeEnum.BRAZILIEX.getRotulo())){
            var response = ResponseCriptoMoedasDto()
            response.valorCotacaoBitcoin = braziliexService.getCotacaoBitcoinLast()
            response.valorCotacaoBitcoinCash = braziliexService.getCotacaoBitcoinCashLast()
            response.valorCotacaoLitecoin = braziliexService.getCotacaoLitecoinLast()
            response.valorCotacaoEthereum = braziliexService.getCotacaoEthereumLast()
            response.valorCotacaoPaxGold = braziliexService.getCotacaoPaxGoldLast()
            response.valorCotacaoRipple = braziliexService.getCotacaoRippleLast()

            return response
        }
        else if (exchange.equals(ExchangeEnum.NOVADAX.getRotulo())){
            var response = ResponseCriptoMoedasDto()
            response.valorCotacaoBitcoin = novadaxService.getCotacaoBitcoinLast()
            response.valorCotacaoBitcoinCash = novadaxService.getCotacaoBitcoinCashLast()
            response.valorCotacaoLitecoin = novadaxService.getCotacaoLitecoinLast()
            response.valorCotacaoEthereum = novadaxService.getCotacaoEthereumLast()
            response.valorCotacaoRipple = novadaxService.getCotacaoRippleLast()

            return response
        }

        return null
    }
}