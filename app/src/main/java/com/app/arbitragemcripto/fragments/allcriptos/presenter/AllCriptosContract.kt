package com.app.arbitragemcripto.fragments.allcriptos.presenter

import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto

interface AllCriptosContract {

    interface AllCriptosView {
        fun init()
        fun showProgress(visible: Boolean)
        fun showCardViewResult(visible: Boolean)
        fun loadResultAllCripto(result: ResponseCriptoDto)
    }

    interface AllCriptosPresenter {
        fun loadAnalyzeAllCriptos(valorEntrada: String)
    }
}