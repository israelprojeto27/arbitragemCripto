package com.app.arbitragemcripto.fragments.bycripto.presenter

class ByCriptoPresenterImpl (val view : ByCriptoContract.ByCriptoView) : ByCriptoContract.ByCriptoPresenter {


    override fun loadAnalyzeByCripto(valorEntrada: String, cripto: String) {
        view.showCardViewResult(true)
        view.showProgress(true)
    }
}