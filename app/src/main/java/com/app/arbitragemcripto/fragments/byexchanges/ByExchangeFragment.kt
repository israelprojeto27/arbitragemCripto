package com.app.arbitragemcripto.fragments.byexchanges


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.byexchanges.presenter.ByExchangeContract
import com.app.arbitragemcripto.fragments.byexchanges.presenter.ByExchangePresenterImpl
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCriptoDto
import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import kotlinx.android.synthetic.main.fragment_by_exchange.*
import kotlinx.android.synthetic.main.fragment_by_exchange.view.*


class ByExchangeFragment : Fragment(), ByExchangeContract.ByExchangeView {

    lateinit var presenter : ByExchangePresenterImpl
    lateinit var mContext: Context

    lateinit var listaCriptoMoedas : Array<String>
    var criptoMoedaSelecionada = ""

    lateinit var listaExchangeCompra : Array<String>
    var exchangeCompraSelecionada = ""

    lateinit var listaExchangeVenda : Array<String>
    var exchangeVendaSelecionada = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_by_exchange, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Por Exchanges"

        init(view)
        return view
    }

    override fun init(view: View) {
        presenter = ByExchangePresenterImpl(this)
        mContext = this.context!!
        clickActions(view)
        loadSpinnerCriptoMoeda(view)
        loadSpinnerExchangeCompra(view)
        loadSpinnerExchangeVenda(view)
        clickSpinnerCriptoMoeda(view)
        clickSpinnerExchangeCompra(view)
        clickSpinnerExchangeVenda(view)
    }

    override fun showProgress(visible: Boolean) {
        if ( visible )
            progressBarByExchangesFragment.visibility = View.VISIBLE
        else
            progressBarByExchangesFragment.visibility = View.INVISIBLE
    }

    override fun showCardViewResult(visible: Boolean) {
        if ( visible )
            cardViewResultadoByExchange.visibility = View.VISIBLE
        else
            cardViewResultadoByExchange.visibility = View.INVISIBLE
    }

    override fun loadResultAllCripto(result: ResponseCriptoDto) {
        criptoMoedaSelecionadaByExchangesFragment.text = result.nomeCriptoMoeda
        exchangeCompraByExchangesFragment.text = result.exchangeCompra
        precoCompraByExchangesFragment.text = result.valorCompra.toString()

        exchangeVendaByExchangesFragment.text = result.exchangeVenda
        precoVendaByExchangesFragment.text = result.valorVenda.toString()

        quantidadeCriptomoedaByExchangesFragment.text = result.quantidadeCriptomoeda.toString()
        valorLucroBrutoByExchangesFragment.text = result.valorLucro.toString()
        totalTaxasByExchangesFragment.text = result.totalTaxa.toString()
    }

    private fun clickSpinnerExchangeVenda(view: View) {
        view.spinnerExchangeVendaByExchangesFragment.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {       }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                exchangeVendaSelecionada = listaExchangeVenda[position]
            }
        }
    }

    private fun clickSpinnerExchangeCompra(view: View) {
        view.spinnerExchangeCompraByExchangesFragment.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {       }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                exchangeCompraSelecionada = listaExchangeCompra[position]
            }
        }
    }

    private fun clickSpinnerCriptoMoeda(view: View) {
        view.spinnerCriptoMoedaByExchangesFragment.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {       }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                criptoMoedaSelecionada = listaCriptoMoedas[position]
            }
        }
    }

    private fun loadSpinnerExchangeVenda(view: View) {
        var list : List<String> = ArrayList<String>()
        list += ""
        ExchangeEnum.values().forEach { elem -> list+= elem.label }

        listaExchangeVenda = list.toTypedArray()
        val arratAdapter= ArrayAdapter(mContext, android.R.layout.simple_spinner_item, listaExchangeVenda)
        view.spinnerExchangeVendaByExchangesFragment.adapter = arratAdapter
    }

    private fun loadSpinnerExchangeCompra(view: View) {
        var list : List<String> = ArrayList<String>()
        list += ""
        ExchangeEnum.values().forEach { elem -> list+= elem.label }

        listaExchangeCompra = list.toTypedArray()
        val arratAdapter= ArrayAdapter(mContext, android.R.layout.simple_spinner_item, listaExchangeCompra)
        view.spinnerExchangeCompraByExchangesFragment.adapter = arratAdapter
    }

    private fun loadSpinnerCriptoMoeda(view: View) {
        var list : List<String> = ArrayList<String>()
        list += ""
        CriptoMoedaEnum.values().forEach { elem -> list+= elem.label }

        listaCriptoMoedas = list.toTypedArray()
        val arratAdapter= ArrayAdapter(mContext, android.R.layout.simple_spinner_item, listaCriptoMoedas)
        view.spinnerCriptoMoedaByExchangesFragment.adapter = arratAdapter
    }

    private fun clickActions(view: View) {
        view.btnAnalisarByExchange.setOnClickListener{
            var valorEntrada = valorEntradaByExchangesFragment.text.toString()
            var cripto = CriptoMoedaEnum.values().firstOrNull{it.label == criptoMoedaSelecionada}?.codigo
            var exchangeCompra = ExchangeEnum.values().firstOrNull{it.label == exchangeCompraSelecionada}?.codigo
            var exchangeVenda = ExchangeEnum.values().firstOrNull{it.label == exchangeVendaSelecionada}?.codigo

            if (! valorEntrada.isNullOrEmpty() &&
                ! exchangeCompra.isNullOrEmpty()  &&
                ! exchangeVenda.isNullOrEmpty() ){

                presenter.loadAnalyzeByExchange(valorEntrada, cripto, exchangeCompra, exchangeVenda)
            }
            else {
                Toast.makeText(mContext, "Campos obrigatorios nao informados", Toast.LENGTH_LONG).show()
            }
        }
    }
}
