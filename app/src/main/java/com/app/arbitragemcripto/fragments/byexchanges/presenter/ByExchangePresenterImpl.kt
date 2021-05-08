package com.app.arbitragemcripto.fragments.byexchanges.presenter

class ByExchangePresenterImpl (val view : ByExchangeContract.ByExchangeView) : ByExchangeContract.ByExchangePresenter {


    override fun loadAnalyzeByExchange(
        valorEntrada: String,
        cripto: String?,
        exchangeCompra: String,
        exchangeVenda: String
    ) {
        view.showCardViewResult(true)
        view.showProgress(true)
    }
}