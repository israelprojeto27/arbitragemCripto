package com.app.arbitragemcripto.fragments.commons.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.arbitragemcripto.R
import com.app.arbitragemcripto.fragments.commons.dto.ResponseCotacaoDto
import kotlinx.android.synthetic.main.item_layout_cotacao.view.*

class AdapterListCotacao : RecyclerView.Adapter<AdapterListCotacao.ViewHolder> {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    var mContext : Context
    var tipoCotacao: String = ""

    constructor( mContext: Context, tipoCotacao: String) : super() {
        this.mContext = mContext
        this.tipoCotacao = tipoCotacao
    }

    private val differCallback = object : DiffUtil.ItemCallback<ResponseCotacaoDto>(){
        override fun areItemsTheSame(oldItem: ResponseCotacaoDto, newItem: ResponseCotacaoDto): Boolean {
            return oldItem.label  == newItem.label
        }

        override fun areContentsTheSame(oldItem: ResponseCotacaoDto, newItem: ResponseCotacaoDto): Boolean {
            return oldItem.label == newItem.label
        }
    }

    var differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_cotacao, parent, false)

        return ViewHolder(itemView);
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cotacaoDto = differ.currentList?.get(position)

        holder.itemView.apply {
            textLabelCotacao.text = cotacaoDto.label
            textValorCotacao.text = cotacaoDto.value.toString()

            if (tipoCotacao.equals("porCripto")){
                labelAdapterListaCotacao.text = "Exchange"
            }
            else if (tipoCotacao.equals("porExchange")){
                labelAdapterListaCotacao.text = "CriptoMoeda"
            }
        }
    }
}