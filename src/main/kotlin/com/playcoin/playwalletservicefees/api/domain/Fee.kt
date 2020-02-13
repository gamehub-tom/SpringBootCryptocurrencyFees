package com.playcoin.playwalletservicefees.api.domain

import java.math.BigDecimal

data class Fee(
    val slow: BigDecimal,
    val normal: BigDecimal,
    val fast: BigDecimal) {}

typealias FeeResponse = ApiResponse<Fee>