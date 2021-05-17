package com.app.arbitragemcripto.fragments.service.dto

data class DetailCotacaoArbitragemDto(
    val nomeExchange: String,
    val valorCotacao: Double? = null,
    val valorCotacaoCompra: Double? = null,
    val valorCotacaoVenda: Double? = null) {

    constructor(nomeExchange: String, valorCotacao: Double): this(nomeExchange, valorCotacao, null, null) {

    }


    constructor(nomeExchange: String, valorCotacaoCompra: Double, valorCotacaoVenda: Double): this(nomeExchange, null, valorCotacaoCompra, valorCotacaoVenda) {

    }


}



