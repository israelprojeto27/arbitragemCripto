package com.app.arbitragemcripto.fragments.service.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class DTOError(
    @SerializedName("title")
    var title: String?,

    @SerializedName("message")
    var message: String?,

    @SerializedName("isNotAuthorized")
    var isNotAuthorized: Boolean = false
) : Parcelable