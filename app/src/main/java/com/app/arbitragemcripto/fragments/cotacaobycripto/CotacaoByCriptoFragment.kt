package com.app.arbitragemcripto.fragments.cotacaobycripto


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
import com.app.arbitragemcripto.fragments.cotacaobycripto.presenter.CotacaoByCriptoContract
import com.app.arbitragemcripto.fragments.cotacaobycripto.presenter.CotacaoByCriptoPresenterImpl
import kotlinx.android.synthetic.main.fragment_cotacao_by_cripto.*
import kotlinx.android.synthetic.main.fragment_cotacao_by_cripto.view.*


class CotacaoByCriptoFragment : Fragment(), CotacaoByCriptoContract.CotacaoByCriptoView {

    lateinit var presenter : CotacaoByCriptoPresenterImpl
    lateinit var mContext: Context

    lateinit var listaCriptoMoedas : Array<String>
    var criptoMoedaSelecionada = ""

    private val adapterListCotacaao by lazy {
        AdapterListCotacao(mContext, "porCripto")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Cotação por Criptomoeda"

        val view = inflater.inflate(R.layout.fragment_cotacao_by_cripto, container, false)
        init(view)
        clickActions(view)
        configRecycle(view)

        return view
    }

    private fun configRecycle(view: View) {
        with(view.recycleViewResultadoCotacaoByCripto){
            adapter = adapterListCotacaao
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(mContext)
            visibility = View.VISIBLE
            hasFixedSize()
        }
    }

    private fun clickActions(view: View) {
        view.btnAnalisarCotacaoByCripto.setOnClickListener{
            var cripto = CriptoMoedaEnum.values().firstOrNull{it.label == criptoMoedaSelecionada}?.codigo

            if ( !cripto.isNullOrEmpty()){
                presenter.loadCotacaoByCripto(cripto)
            }
            else {
                Toast.makeText(mContext, "Campos obrigatorios nao informados", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun init(view: View) {
        presenter = CotacaoByCriptoPresenterImpl(this)
        mContext = this.context!!
        loadSpinnerCriptoMoeda(view)
        clickSpinnerCriptoMoeda(view)
    }

    override fun showCardView(visible: Boolean) {
        if ( visible )
            cardViewCotacaoByCripto.visibility = View.VISIBLE
        else
            cardViewCotacaoByCripto.visibility = View.INVISIBLE
    }

    override fun showProgressBar(visible: Boolean) {
        if ( visible )
            progressBarCotacaoByCripto.visibility = View.VISIBLE
        else
            progressBarCotacaoByCripto.visibility = View.INVISIBLE
    }

    override fun showListCotacao(lista: List<ResponseCotacaoDto>) {
        adapterListCotacaao.differ.submitList(lista)
    }


    private fun loadSpinnerCriptoMoeda(view: View) {
        var list : List<String> = ArrayList<String>()
        list += ""
        CriptoMoedaEnum.values().forEach { elem -> list+= elem.label }

        listaCriptoMoedas = list.toTypedArray()
        val arratAdapter= ArrayAdapter(mContext, android.R.layout.simple_spinner_item, listaCriptoMoedas)
        view.spinnerCriptoMoedaCotacaoByCripto.adapter = arratAdapter
    }

    private fun clickSpinnerCriptoMoeda(view: View) {
        view.spinnerCriptoMoedaCotacaoByCripto.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {       }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                criptoMoedaSelecionada = listaCriptoMoedas[position]
            }
        }
    }
}
