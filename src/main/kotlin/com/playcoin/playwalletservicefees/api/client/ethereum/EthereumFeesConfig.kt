package com.playcoin.playwalletservicefees.api.client.ethereum

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EthereumFeesConfig(
    @Value("https://ethgasstation.info")
    val host: String,
    @Value("0")
    val port: Int
)
