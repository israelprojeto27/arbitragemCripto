package com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter

import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto

class CotacaoByExchangesPresenterImpl (val view : CotacaoByExchangesContract.CotacaoByExchangesView): CotacaoByExchangesContract.CotacaoByExchangesPresenter {

    override fun loadCotacaoByExchange(exchange: String) {
        view.showCardView(true)
        view.showProgressBar(true)


        var list : java.util.ArrayList<ResponseCotacaoDto> = ArrayList<ResponseCotacaoDto>()
        var dto = ResponseCotacaoDto("Litecoint", "R$ 1500,00")
        list.add(dto)

        dto = ResponseCotacaoDto("Dash", "R$ 1500,00")
        list.add(dto)

        dto = ResponseCotacaoDto("Ripple", "R$ 2700,00")
        list.add(dto)

        view.showProgressBar(false)
        view.showListCotacao(list)

    }
}