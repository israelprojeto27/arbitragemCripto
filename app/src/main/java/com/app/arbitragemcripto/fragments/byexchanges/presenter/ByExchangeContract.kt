package com.app.arbitragemcripto.fragments.byexchanges.presenter

import android.view.View
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto

interface ByExchangeContract {

    interface ByExchangeView {
        fun init(view: View)
        fun showProgress(visible: Boolean)
        fun showCardViewResult(visible: Boolean)
        fun loadResultAllCripto(result: ResponseCriptoDto)
    }

    interface ByExchangePresenter {
        fun loadAnalyzeByExchange(valorEntrada: String, cripto: String?, exchangeCompra: String, exchangeVenda: String)

    }
}