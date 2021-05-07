package com.app.arbitragemcripto.fragments.cotacaobyexchanges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter.CotacaoByExchangesContract
import com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter.CotacaoByExchangesPresenterImpl


class CotacaoByExchangesFragment : Fragment(), CotacaoByExchangesContract.CotacaoByExchangesView {

    lateinit var presenter : CotacaoByExchangesPresenterImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        init()

        return inflater.inflate(R.layout.fragment_cotacao_by_exchanges, container, false)
    }

    override fun init() {
        presenter = CotacaoByExchangesPresenterImpl(this)
    }

}
