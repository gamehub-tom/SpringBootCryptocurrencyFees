package com.playcoin.playwalletservicefees.api.domain

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

data class Fee(
    val slow: BigDecimal,

    val normal: BigDecimal,

    val fast: BigDecimal,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val gasLimit: BigDecimal?) {}

typealias FeeResponse = ApiResponse<Fee>