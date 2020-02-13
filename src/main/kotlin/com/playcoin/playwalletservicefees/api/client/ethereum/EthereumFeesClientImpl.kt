package com.playcoin.playwalletservicefees.api.client.ethereum

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesService
import com.playcoin.playwalletservicefees.api.client.bitcoin.ServiceGenerator
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class EthereumFeesClientImpl(private val config: EthereumFeesConfig): EthereumFeesClient {

    val service: EthereumFeesService =
        ServiceGenerator(config.host, config.port).createService<EthereumFeesService>()

    override fun fees(): EthereumFeesRes = kotlin.run {
        service.ethgas().execute().let {
            if (it.isSuccessful) it.body() ?: throw RuntimeException("Ethereum fees null")
            else throw RuntimeException(it.errorBody().toString())
        }
    }
}