package com.app.arbitragemcripto.fragments.bycripto.presenter

import com.app.arbitragemcripto.fragments.service.ArbitragemService

class ByCriptoPresenterImpl (val view : ByCriptoContract.ByCriptoView) : ByCriptoContract.ByCriptoPresenter {

    var arbitragemService = ArbitragemService()

    override fun loadAnalyzeByCripto(valorEntrada: String, cripto: String) {
        view.showCardViewResult(true)
        view.showProgress(true)

        var ret = arbitragemService.loadAnalyzeByCripto(valorEntrada, cripto)

        view.loadResultByCripto(ret!!)

        view.showProgress(false)
    }
}