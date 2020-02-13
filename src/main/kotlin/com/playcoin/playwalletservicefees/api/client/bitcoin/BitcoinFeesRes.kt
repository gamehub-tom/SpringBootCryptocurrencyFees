package com.playcoin.playwalletservicefees.api.client.bitcoin

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class BitcoinFeesRes(
    @SerializedName("fastestFee")
    val fastestFee: BigDecimal,

    @SerializedName("halfHourFee")
    val halfHourFee: BigDecimal,

    @SerializedName("hourFee")
    val hourFee: BigDecimal) {}
