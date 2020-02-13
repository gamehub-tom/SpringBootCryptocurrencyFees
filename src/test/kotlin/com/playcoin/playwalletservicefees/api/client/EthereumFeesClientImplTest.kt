package com.playcoin.playwalletservicefees.api.client

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesClient
import com.playcoin.playwalletservicefees.api.client.ethereum.EthereumFeesClient
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EthereumFeesClientImplTest {

    @Autowired
    lateinit var client: EthereumFeesClient

    @Test
    fun beanNotNull() {
        Assertions.assertThat(client).isNotNull
    }

    @Test
    fun fees() {
        val res = client.fees()
        Assertions.assertThat(res).isNotNull
        Assertions.assertThat(res.fast).isNotNull()
        Assertions.assertThat(res.average).isNotNull()
        Assertions.assertThat(res.safeLow).isNotNull()
        Assertions.assertThat(res.gasPriceRange).isNotNull
        Assertions.assertThat(res.gasPriceRange.r4).isNotNull()
        Assertions.assertThat(res.gasPriceRange.r180).isNotNull()
    }
}