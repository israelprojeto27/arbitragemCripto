package com.app.arbitragemcripto.fragments.bycripto.presenter

import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto

interface ByCriptoContract {

    interface ByCriptoView {
        fun init()
        fun showProgress(visible: Boolean)
        fun showCardViewResult(visible: Boolean)
        fun loadResultByCripto(result: ResponseCriptoDto)
    }

    interface ByCriptoPresenter {
        fun loadAnalyzeByCripto(valorEntrada: String, cripto: String)
    }
}