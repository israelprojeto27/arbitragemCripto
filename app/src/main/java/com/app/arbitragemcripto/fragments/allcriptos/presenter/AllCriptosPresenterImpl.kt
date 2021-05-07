package com.app.arbitragemcripto.fragments.allcriptos.presenter

class AllCriptosPresenterImpl (val view : AllCriptosContract.AllCriptosView) : AllCriptosContract.AllCriptosPresenter {


    override fun loadAnalyzeAllCriptos(valorEntrada: String) {
        view.showCardViewResult(true)
        view.showProgress(true)


    }
}