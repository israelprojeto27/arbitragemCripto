package com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter

import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto
import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.service.CotacaoService

class CotacaoByExchangesPresenterImpl (val view : CotacaoByExchangesContract.CotacaoByExchangesView): CotacaoByExchangesContract.CotacaoByExchangesPresenter {

    var cotacaoService = CotacaoService()

    override fun loadCotacaoByExchange(exchange: String) {
        view.showCardView(true)
        view.showProgressBar(true)

        var ret = cotacaoService.loadCotacaoByExchange(exchange)
        var dto = ResponseCotacaoDto("", 0.0)
        var list = ArrayList<ResponseCotacaoDto>()
        if (ret?.valorCotacaoBitcoin != null && ret?.valorCotacaoBitcoin > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.BITCOIN.getIdentificador(), ret.valorCotacaoBitcoin)
            list.add(dto)
        }
        if (ret?.valorCotacaoBitcoinCash != null && ret?.valorCotacaoBitcoinCash > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.BITCOIN_CASH.getIdentificador(), ret.valorCotacaoBitcoinCash)
            list.add(dto)
        }
        if (ret?.valorCotacaoLitecoin != null && ret?.valorCotacaoLitecoin > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.LITECOIN.getIdentificador(), ret.valorCotacaoLitecoin)
            list.add(dto)
        }
        if (ret?.valorCotacaoRipple != null && ret?.valorCotacaoRipple > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.RIPPLE.getIdentificador(), ret.valorCotacaoRipple)
            list.add(dto)
        }
        if (ret?.valorCotacaoDash != null && ret?.valorCotacaoDash > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.DASH.getIdentificador(), ret.valorCotacaoDash)
            list.add(dto)
        }
        if (ret?.valorCotacaoChainLink != null && ret?.valorCotacaoChainLink > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.CHAINLINK.getIdentificador(), ret.valorCotacaoChainLink)
            list.add(dto)
        }
        if (ret?.valorCotacaoPaxGold != null && ret?.valorCotacaoPaxGold > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.PAXGOLD.getIdentificador(), ret.valorCotacaoPaxGold)
            list.add(dto)
        }
        if (ret?.valorCotacaoChiliz != null && ret?.valorCotacaoPaxGold > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.CHILIZ.getIdentificador(), ret.valorCotacaoChiliz)
            list.add(dto)
        }
        if (ret?.valorCotacaoTether != null && ret?.valorCotacaoTether > 0){
            dto = ResponseCotacaoDto (CriptoMoedaEnum.TETHER.getIdentificador(), ret.valorCotacaoTether)
            list.add(dto)
        }

        view.showProgressBar(false)
        view.showListCotacao(list)
    }
}