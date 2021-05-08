package com.app.arbitragemcripto.fragments.cotacaobyexchanges

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
import com.app.arbitragemcripto.fragments.commons.adapter.AdapterListCotacao
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto
import com.app.arbitragemcripto.fragments.commons.enumerate.CriptoMoedaEnum
import com.app.arbitragemcripto.fragments.commons.enumerate.ExchangeEnum
import com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter.CotacaoByExchangesContract
import com.app.arbitragemcripto.fragments.cotacaobyexchanges.presenter.CotacaoByExchangesPresenterImpl
import kotlinx.android.synthetic.main.fragment_cotacao_by_cripto.view.*
import kotlinx.android.synthetic.main.fragment_cotacao_by_exchanges.*
import kotlinx.android.synthetic.main.fragment_cotacao_by_exchanges.view.*


class CotacaoByExchangesFragment : Fragment(), CotacaoByExchangesContract.CotacaoByExchangesView {

    lateinit var presenter : CotacaoByExchangesPresenterImpl
    lateinit var mContext: Context

    lateinit var listaExchanges : Array<String>
    var exchangeSelecionada = ""

    private val adapterListCotacaao by lazy {
        AdapterListCotacao(mContext, "porExchange")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Cotação por Exchanges"

        val view = inflater.inflate(R.layout.fragment_cotacao_by_exchanges, container, false)

        init(view)
        clickActions(view)
        configRecycle(view)

        return view
    }

    private fun configRecycle(view: View) {
        with(view.recycleViewResultadoCotacaoByExchange){
            adapter = adapterListCotacaao
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(mContext)
            visibility = View.VISIBLE
            hasFixedSize()
        }
    }

    private fun clickActions(view: View) {
        view.btnAnalisarCotacaoByExchange.setOnClickListener{
            var exchange = ExchangeEnum.values().firstOrNull{it.label == exchangeSelecionada}?.codigo

            if ( !exchange.isNullOrEmpty()){
                presenter.loadCotacaoByExchange(exchange)
            }
            else {
                Toast.makeText(mContext, "Campos obrigatorios nao informados", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun init(view: View) {
        presenter = CotacaoByExchangesPresenterImpl(this)
        mContext = this.context!!
        loadSpinnerExchange(view)
        clickSpinnerExchange(view)
    }

    override fun showCardView(visible: Boolean) {
        if ( visible )
            cardViewCotacaoByExchange.visibility = View.VISIBLE
        else
            cardViewCotacaoByExchange.visibility = View.INVISIBLE
    }

    override fun showProgressBar(visible: Boolean) {
        if ( visible )
            progressBarCotacaoByExchange.visibility = View.VISIBLE
        else
            progressBarCotacaoByExchange.visibility = View.INVISIBLE
    }

    override fun showListCotacao(lista: ArrayList<ResponseCotacaoDto>) {
        adapterListCotacaao.differ.submitList(lista)
    }

    private fun clickSpinnerExchange(view: View) {
        view.spinnerExchangeCotacaoByExchange.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {       }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                exchangeSelecionada = listaExchanges[position]
            }
        }
    }

    private fun loadSpinnerExchange(view: View) {
        var list : List<String> = ArrayList<String>()
        list += ""
        ExchangeEnum.values().forEach { elem -> list+= elem.label }

        listaExchanges = list.toTypedArray()
        val arratAdapter= ArrayAdapter(mContext, android.R.layout.simple_spinner_item, listaExchanges)
        view.spinnerExchangeCotacaoByExchange.adapter = arratAdapter
    }

}
