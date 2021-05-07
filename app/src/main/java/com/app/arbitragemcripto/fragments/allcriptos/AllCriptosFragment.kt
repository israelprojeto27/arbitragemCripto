package com.app.arbitragemcripto.fragments.allcriptos


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto
import com.app.arbitragemcripto.fragments.allcriptos.presenter.AllCriptosContract
import com.app.arbitragemcripto.fragments.allcriptos.presenter.AllCriptosPresenterImpl
import kotlinx.android.synthetic.main.fragment_all_criptos.*
import kotlinx.android.synthetic.main.fragment_all_criptos.view.*


class AllCriptosFragment : Fragment(), AllCriptosContract.AllCriptosView {

    lateinit var presenter : AllCriptosPresenterImpl
    lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_criptos, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Todas as CriptoMoedas"

        init()
        clickActions(view)
        return view
    }

    private fun clickActions(view: View) {
        view.btnAnalisarAllCriptos.setOnClickListener{
            val entrada = valorEntradaAllCriptosFragment.text.toString()
            if (! entrada.isNullOrEmpty()) {
                presenter.loadAnalyzeAllCriptos(entrada)
            }
            else {
                Toast.makeText(mContext, "Não é analisar sem um valor de entrada", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun init() {
        presenter = AllCriptosPresenterImpl(this)
        mContext = this.context!!
    }

    override fun showProgress(visible: Boolean) {
        if ( visible )
            progressBarAllCriptosFragment.visibility = View.VISIBLE
        else
            progressBarAllCriptosFragment.visibility = View.INVISIBLE
    }

    override fun showCardViewResult(visible: Boolean) {
        if ( visible )
            cardViewResultadoAllCriptos.visibility = View.VISIBLE
        else
            cardViewResultadoAllCriptos.visibility = View.INVISIBLE
    }

    override fun loadResultAllCripto(result: ResponseCriptoDto) {
        criptoMoedaSelecionadaAllCriptosFragment.text = result.nomeCriptoMoeda
        exchangeCompraAllCriptosFragment.text = result.exchangeCompra
        precoCompraAllCriptosFragment.text = result.valorCompra.toString()

        exchangeVendaAllCriptosFragment.text = result.exchangeVenda
        precoVendaAllCriptosFragment.text = result.valorVenda.toString()

        quantidadeCriptomoedaAllCriptosFragment.text = result.quantidadeCriptomoeda.toString()
        valorLucroBrutoAllCriptosFragment.text = result.valorLucro.toString()
        totalTaxasAllCriptosFragment.text = result.totalTaxa.toString()
    }


}
