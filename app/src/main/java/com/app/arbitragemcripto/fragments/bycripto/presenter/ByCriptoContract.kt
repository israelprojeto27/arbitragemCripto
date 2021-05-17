package com.app.arbitragemcripto.fragments.bycripto.presenter

import com.app.arbitragemcripto.fragments.service.dto.ResponseArbitragemCriptoMoedaDto

interface ByCriptoContract {

    interface ByCriptoView {
        fun init()
        fun showProgress(visible: Boolean)
        fun showCardViewResult(visible: Boolean)
        fun loadResultByCripto(result: ResponseArbitragemCriptoMoedaDto)
    }

    interface ByCriptoPresenter {
        fun loadAnalyzeByCripto(valorEntrada: String, cripto: String)
    }
}