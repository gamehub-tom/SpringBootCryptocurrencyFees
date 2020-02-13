package com.playcoin.playwalletservicefees.api.client.ethereum

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class EthereumFeesRes(
    @SerializedName("fast")
    val fast: BigDecimal,

    @SerializedName("fastest")
    val fastest: BigDecimal,

    @SerializedName("safeLow")
    val safeLow: BigDecimal,

    @SerializedName("average")
    val average: BigDecimal,

    @SerializedName("block_time")
    val blockTime: BigDecimal,

    @SerializedName("blockNum")
    val blockNum: BigDecimal,

    @SerializedName("speed")
    val speed: BigDecimal,

    @SerializedName("safeLowWait")
    val safeLowWait: BigDecimal,

    @SerializedName("avgWait")
    val avgWait: BigDecimal,

    @SerializedName("fastWait")
    val fastWait: BigDecimal,

    @SerializedName("fastestWait")
    val fastestWait: BigDecimal,

    @SerializedName("gasPriceRange")
    val gasPriceRange: GasPriceRange) {}

data class GasPriceRange(
    @SerializedName("180")
    val r180: BigDecimal,

    @SerializedName("170")
    val r170: BigDecimal,

    @SerializedName("160")
    val r160: BigDecimal,

    @SerializedName("150")
    val r150: BigDecimal,

    @SerializedName("140")
    val r140: BigDecimal,

    @SerializedName("130")
    val r130: BigDecimal,

    @SerializedName("120")
    val r120: BigDecimal,

    @SerializedName("110")
    val r110: BigDecimal,

    @SerializedName("100")
    val r100: BigDecimal,

    @SerializedName("90")
    val r90: BigDecimal,

    @SerializedName("80")
    val r80: BigDecimal,

    @SerializedName("70")
    val r70: BigDecimal,

    @SerializedName("60")
    val r60: BigDecimal,

    @SerializedName("50")
    val r50: BigDecimal,

    @SerializedName("40")
    val r40: BigDecimal,

    @SerializedName("30")
    val r30: BigDecimal,

    @SerializedName("20")
    val r20: BigDecimal,

    @SerializedName("10")
    val r10: BigDecimal,

    @SerializedName("8")
    val r8: BigDecimal,

    @SerializedName("6")
    val r6: BigDecimal,

    @SerializedName("4")
    val r4: BigDecimal) {}
