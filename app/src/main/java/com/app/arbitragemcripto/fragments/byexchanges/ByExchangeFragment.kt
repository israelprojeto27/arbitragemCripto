package com.app.arbitragemcripto.fragments.byexchanges


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.byexchanges.presenter.ByExchangeContract
import com.app.arbitragemcripto.fragments.byexchanges.presenter.ByExchangePresenterImpl


class ByExchangeFragment : Fragment(), ByExchangeContract.ByExchangeView {

    lateinit var presenter : ByExchangePresenterImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        init()

        return inflater.inflate(R.layout.fragment_by_exchange, container, false)
    }

    override fun init() {
        presenter = ByExchangePresenterImpl(this)
    }

}
