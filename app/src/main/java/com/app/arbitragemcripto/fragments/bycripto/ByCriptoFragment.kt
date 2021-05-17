package com.app.arbitragemcripto.fragments.bycripto


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.bycripto.presenter.ByCriptoContract
import com.app.arbitragemcripto.fragments.bycripto.presenter.ByCriptoPresenterImpl
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto
import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.service.dto.ResponseArbitragemCriptoMoedaDto
import kotlinx.android.synthetic.main.fragment_by_cripto.*
import kotlinx.android.synthetic.main.fragment_by_cripto.view.*


class ByCriptoFragment : Fragment() , ByCriptoContract.ByCriptoView {

    lateinit var presenter : ByCriptoPresenterImpl
    lateinit var mContext: Context
    lateinit var listaCriptoMoedas : Array<String>
    var criptoMoedaSelecionada = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_by_cripto, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Por CriptoMoeda"

        init()
        clickActions(view)
        loadSpinnerCriptoMoeda(view)
        clickSpinnerCriptoMoeda(view)
        return view
    }

    private fun clickSpinnerCriptoMoeda(view: View) {
        view.spinnerByCriptoFragment.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {       }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                criptoMoedaSelecionada = listaCriptoMoedas[position]
            }
        }
    }

    private fun loadSpinnerCriptoMoeda(view: View) {
        var list : List<String> = ArrayList<String>()
        list += ""
        CriptoMoedaEnum.values().forEach { elem -> list+= elem.label }

        listaCriptoMoedas = list.toTypedArray()
        val arratAdapter= ArrayAdapter(mContext, android.R.layout.simple_spinner_item, listaCriptoMoedas)
        view.spinnerByCriptoFragment.adapter = arratAdapter
    }

    private fun clickActions(view: View) {
        view.btnAnalisarByCripto.setOnClickListener{
            var valorEntrada = valorEntradaByCriptoFragment.text.toString()
            var cripto = CriptoMoedaEnum.values().firstOrNull{it.label == criptoMoedaSelecionada}?.codigo

            if (! valorEntrada.isNullOrEmpty() && !cripto.isNullOrEmpty()){
                presenter.loadAnalyzeByCripto(valorEntrada, cripto)
            }
            else {
                Toast.makeText(mContext, "Campos obrigatorios nao informados", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun init() {
        presenter = ByCriptoPresenterImpl(this)
        mContext = this.context!!
    }

    override fun showProgress(visible: Boolean) {
        if ( visible )
            progressBarByCriptoFragment.visibility = View.VISIBLE
        else
            progressBarByCriptoFragment.visibility = View.INVISIBLE
    }

    override fun showCardViewResult(visible: Boolean) {
        if ( visible )
            cardViewResultadoByCripto.visibility = View.VISIBLE
        else
            cardViewResultadoByCripto.visibility = View.INVISIBLE
    }

    override fun loadResultByCripto(result: ResponseArbitragemCriptoMoedaDto) {
        criptoMoedaSelecionadaByCriptoFragment.text = result.nomeCriptoMoeda
        exchangeCompraByCriptoFragment.text = result.exchangeCompra
        precoCompraByCriptoFragment.text = result.valorCompra.toString()

        exchangeVendaByCriptoFragment.text = result.exchangeVenda
        precoVendaByCriptoFragment.text = result.valorVenda.toString()

        quantidadeCriptomoedaByCriptoFragment.text = result.quantidadeCriptomoeda.toString()
        valorLucroBrutoByCriptoFragment.text = result.valorLucro.toString()
        totalTaxasByCriptoFragment.text = result.totalTaxa.toString()
    }
}
