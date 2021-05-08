package com.app.arbitragemcripto.fragments.cotacaobycripto.presenter

import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto

class CotacaoByCriptoPresenterImpl (val view : CotacaoByCriptoContract.CotacaoByCriptoView): CotacaoByCriptoContract.CotacaoByCriptoPresenter {

    override fun loadCotacaoByCripto(cripto: String) {
        view.showCardView(true)
        view.showProgressBar(true)

        var list : java.util.ArrayList<ResponseCotacaoDto> = ArrayList<ResponseCotacaoDto>()
        var dto = ResponseCotacaoDto("Mercardo Bitcoin", "R$ 1500,00")
        list.add(dto)

        dto = ResponseCotacaoDto("NovaDax", "R$ 1500,00")
        list.add(dto)

        view.showProgressBar(false)
        view.showListCotacao(list)
    }
}