package com.app.arbitragemcripto.fragments.allcriptos.presenter

import com.app.arbitragemcripto.fragments.service.ArbitragemService
import kotlinx.coroutines.*

class AllCriptosPresenterImpl (val view : AllCriptosContract.AllCriptosView) : AllCriptosContract.AllCriptosPresenter {

    var arbitragemService = ArbitragemService()

    override fun loadAnalyzeAllCriptos(valorEntrada: String) {
        view.showCardViewResult(true)
        view.showProgress(true)

        var ret = arbitragemService.loadAnalyzeAllCriptos(valorEntrada)

        view.loadResultAllCripto(ret!!)

        view.showProgress(false)
    }

    @Suppress("LeakingThis")
    protected val scope = createScope()

    protected open fun createScope(): CoroutineScope = MainScope() + Dispatchers.IO

    fun close() {
        scope.cancel()
    }

    protected suspend fun <T> runUi(block: suspend CoroutineScope.() -> T): T = withContext(Dispatchers.Main, block)

}