package com.app.arbitragemcripto.fragments.commons.enumerate

enum class ExchangeEnum (val codigo:String, val label:String) {

    MERCADO_BITCOIN("MercadoBitcoin", "Mercado Bitcoin"),
    BRAZILIEX("Braziliex", "Braziliex"),
    NOVADAX("NovaDax", "NovaDax"),
    BITCOIN_TRADE("BitcoinTrada", "Bitcoin Trada"),
    BINANCE("Binance", "Binance"),
    BITCAMBIO("Bitcambio", "Bitcambio");

    open fun getRotulo(): String? {
        return codigo
    }

    open fun getIdentificador(): String? {
        return label
    }

    open fun getLabel(key: String?): String? {
        return if (key != null && key != "") ExchangeEnum.valueOf(key)
            .getRotulo() else ""
    }

    open fun getNome(key: String?): String? {
        return if (key != null && key != "") ExchangeEnum.valueOf(key)
            .getIdentificador() else ""
    }

}