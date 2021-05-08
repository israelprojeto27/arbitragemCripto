package com.app.arbitragemcripto.fragments.cotacaobycripto.presenter

import android.view.View
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto

interface CotacaoByCriptoContract {

    interface CotacaoByCriptoView {
        fun init(view: View)
        fun showCardView(visible: Boolean)
        fun showProgressBar(visible: Boolean)
        fun showListCotacao(list: List<ResponseCotacaoDto>)
    }

    interface CotacaoByCriptoPresenter {
        fun loadCotacaoByCripto(cripto: String)

    }

}