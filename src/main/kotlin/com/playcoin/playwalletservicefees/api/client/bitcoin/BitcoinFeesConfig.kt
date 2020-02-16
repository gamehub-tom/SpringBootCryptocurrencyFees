package com.playcoin.playwalletservicefees.api.client.bitcoin

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class BitcoinFeesConfig(
    @Value("\${gamehub.bitcoin.host}")
    val host: String,
    @Value("\${gamehub.bitcoin.port}")
    val port: Int
)
