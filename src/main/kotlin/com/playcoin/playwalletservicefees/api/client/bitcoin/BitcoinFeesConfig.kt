package com.playcoin.playwalletservicefees.api.client.bitcoin

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class BitcoinFeesConfig(
    @Value("https://bitcoinfees.earn.com/")
    val host: String,
    @Value("0")
    val port: Int
)