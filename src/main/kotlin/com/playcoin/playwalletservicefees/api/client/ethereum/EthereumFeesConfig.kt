package com.playcoin.playwalletservicefees.api.client.ethereum

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EthereumFeesConfig(
    @Value("\${gamehub.ethereum.host}")
    val host: String,
    @Value("\${gamehub.ethereum.port}")
    val port: Int
)
