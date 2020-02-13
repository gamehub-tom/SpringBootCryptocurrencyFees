package com.playcoin.playwalletservicefees.enums

enum class ResponseStatus(val code: String, val message: String) {
    OK("OK", "Ok"),
    ERROR("001", "Internal Server Error")
}