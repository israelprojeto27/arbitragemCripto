package com.app.arbitragemcripto.fragments.cotacaobycripto


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.cotacaobycripto.presenter.CotacaoByCriptoContract
import com.app.arbitragemcripto.fragments.cotacaobycripto.presenter.CotacaoByCriptoPresenterImpl


class CotacaoByCriptoFragment : Fragment(), CotacaoByCriptoContract.CotacaoByCriptoView {

    lateinit var presenter : CotacaoByCriptoPresenterImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        init()

        return inflater.inflate(R.layout.fragment_cotacao_by_cripto, container, false)
    }

    override fun init() {

    }


}
