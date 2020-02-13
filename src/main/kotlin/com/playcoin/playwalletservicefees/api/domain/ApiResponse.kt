package com.playcoin.playwalletservicefees.api.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.playcoin.playwalletservicefees.enums.ResponseStatus

data class ApiResponse<T>(
    val status: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var error: String? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var data: T?
) {
    companion object {

        fun <T> fromResult(result: Result<T>) = result
            .fold(
                onSuccess = { ApiResponse<T>(ResponseStatus.OK.code, null, it) },
                onFailure = { ApiResponse<T>(ResponseStatus.ERROR.code, it.toString(), null) })

    }
}