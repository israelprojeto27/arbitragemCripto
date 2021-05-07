package com.app.arbitragemcripto.fragments.commons.dto

data class ResponseCriptoDto(var isSucesso: Boolean,
                             var mensagemSucesso: String,
                             var mensagemErro: String,
                             var message: String,
                             var nomeCriptoMoeda: String,
                             var exchangeCompra: String,
                             var valorCompra: Double,
                             var exchangeVenda: String,
                             var valorVenda: Double,
                             var totalTaxa: Double,
                             var valorLucro: Double,
                             var quantidadeCriptomoeda: Double)

