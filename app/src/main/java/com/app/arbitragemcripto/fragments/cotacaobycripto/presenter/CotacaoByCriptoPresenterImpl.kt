package com.app.arbitragemcripto.fragments.cotacaobycripto.presenter

import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.service.CotacaoService

class CotacaoByCriptoPresenterImpl (val view : CotacaoByCriptoContract.CotacaoByCriptoView): CotacaoByCriptoContract.CotacaoByCriptoPresenter {

    var cotacaoService = CotacaoService()

    override fun loadCotacaoByCripto(cripto: String) {
        view.showCardView(true)
        view.showProgressBar(true)


        var ret = cotacaoService.loadCotacaoByCripto(cripto)
        var dto = ResponseCotacaoDto("", 0.0)
        var list = ArrayList<ResponseCotacaoDto>()

        if ( ret?.valorCotacaoMercadoBitcoin != null && ret.valorCotacaoMercadoBitcoin > 0){
            dto = ResponseCotacaoDto (ExchangeEnum.MERCADO_BITCOIN.getIdentificador(), ret.valorCotacaoMercadoBitcoin)
            list.add(dto)
        }

        if ( ret?.valorCotacaoBraziliex != null && ret.valorCotacaoBraziliex > 0){
            dto = ResponseCotacaoDto (ExchangeEnum.BRAZILIEX.getIdentificador(), ret.valorCotacaoBraziliex)
            list.add(dto)
        }

        if ( ret?.valorCotacaoNovadax != null && ret.valorCotacaoNovadax > 0){
            dto = ResponseCotacaoDto (ExchangeEnum.NOVADAX.getIdentificador(), ret.valorCotacaoNovadax)
            list.add(dto)
        }

        if ( ret?.valorCotacaoBinance != null && ret.valorCotacaoBinance > 0){
            dto = ResponseCotacaoDto (ExchangeEnum.BINANCE.getIdentificador(), ret.valorCotacaoBinance)
            list.add(dto)
        }

        if ( ret?.valorCotacaoBitcoinTrade != null && ret.valorCotacaoBitcoinTrade > 0){
            dto = ResponseCotacaoDto (ExchangeEnum.BITCOIN_TRADE.getIdentificador(), ret.valorCotacaoBitcoinTrade)
            list.add(dto)
        }

        view.showProgressBar(false)
        view.showListCotacao(list)
    }
}