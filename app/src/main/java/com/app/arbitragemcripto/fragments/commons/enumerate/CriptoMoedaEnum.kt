package com.app.arbitragemcripto.fragments.commons.enumerate

enum class CriptoMoedaEnum (val codigo:String, val label:String){

    BITCOIN("Bitcoin", "Bitcoin"),
    BITCOIN_CASH("BitcoinCash", "Bitcoin Cash"),
    LITECOIN("Litecoin", "Litecoin"),
    ETHEREUM("Ethereum", "Ethereum"),
    DASH("Dash", "Dash"),
    RIPPLE("Ripple", "Ripple"),
    TETHER("Tether", "Tether"),
    CHILIZ("Chiliz", "Chiliz"),
    CHAINLINK("ChainLink", "ChainLink"),
    PAXGOLD("PaxGold", "PaxGold");


    open fun getRotulo(): String? {
        return codigo
    }

    open fun getIdentificador(): String? {
        return label
    }

    open fun getLabel(key: String?): String? {
        return if (key != null && key != "") CriptoMoedaEnum.valueOf(key)
            .getRotulo() else ""
    }

    open fun getNome(key: String?): String? {
        return if (key != null && key != "") CriptoMoedaEnum.valueOf(key)
            .getIdentificador() else ""
    }
}