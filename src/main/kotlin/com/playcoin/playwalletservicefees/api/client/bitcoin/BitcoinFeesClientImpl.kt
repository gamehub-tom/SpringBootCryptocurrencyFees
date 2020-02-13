package com.playcoin.playwalletservicefees.api.client.bitcoin

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Component
class BitcoinFeesClientImpl(private val config: BitcoinFeesConfig): BitcoinFeesClient {

    val service: BitcoinFeesService =
        ServiceGenerator(config.host, config.port).createService<BitcoinFeesService>()

    override fun fees(): BitcoinFeesRes = kotlin.run {
        service.recommended().execute().let {
            if (it.isSuccessful) it.body() ?: throw RuntimeException("Bitcoin fees null")
            else throw RuntimeException(it.errorBody().toString())
        }
    }
}
