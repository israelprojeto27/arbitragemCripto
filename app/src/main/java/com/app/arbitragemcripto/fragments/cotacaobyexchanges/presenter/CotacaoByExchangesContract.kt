package com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter

import android.view.View
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto

interface CotacaoByExchangesContract {

    interface CotacaoByExchangesView {
        fun init(view: View)
        fun showCardView(visible: Boolean)
        fun showProgressBar(visible: Boolean)
        fun showListCotacao(list: ArrayList<ResponseCotacaoDto>)
    }

    interface CotacaoByExchangesPresenter {
        fun loadCotacaoByExchange(exchange: String)
    }

}