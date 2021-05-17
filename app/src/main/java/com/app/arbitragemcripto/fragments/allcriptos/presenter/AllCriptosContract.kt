package com.app.arbitragemcripto.fragments.allcriptos.presenter

import android.content.Context
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto
import com.app.arbitragemcripto.fragments.service.dto.ResponseArbitragemCriptoMoedaDto

interface AllCriptosContract {

    interface AllCriptosView {
        fun init()
        fun showProgress(visible: Boolean)
        fun showCardViewResult(visible: Boolean)
        fun loadResultAllCripto(result: ResponseArbitragemCriptoMoedaDto)
    }

    interface AllCriptosPresenter {
        fun loadAnalyzeAllCriptos(valorEntrada: String)
    }
}