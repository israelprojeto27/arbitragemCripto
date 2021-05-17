package com.app.arbitragemcripto.fragments.service.dto

data class ResponseArbitragemCriptoMoedaDto (
    val nomeCriptoMoeda: String?,
    val exchangeCompra: String?,
    val valorCompra : Double?,
    val exchangeVenda: String?,
    val valorVenda : Double?,
    val totalTaxa : Double?,
    val valorLucro : Double?,
    val quantidadeCriptomoeda : Double?
)


