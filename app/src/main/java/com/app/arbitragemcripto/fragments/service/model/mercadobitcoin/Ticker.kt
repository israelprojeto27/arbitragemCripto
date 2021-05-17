package com.app.arbitragemcripto.fragments.service.model.mercadobitcoin

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ticker(
    @SerializedName("high")
    val high : String?,
    @SerializedName("low")
    val low : String?,
    @SerializedName("vol")
    val vol : String?,
    @SerializedName("last")
    val last : String?,
    @SerializedName("buy")
    val buy : String?,
    @SerializedName("sell")
    val sell : String?,
    @SerializedName("open")
    val open : String?
):Parcelable
