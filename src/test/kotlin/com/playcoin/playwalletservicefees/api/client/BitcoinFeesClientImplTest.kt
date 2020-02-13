package com.playcoin.playwalletservicefees.api.client

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BitcoinFeesClientImplTest {

    @Autowired
    lateinit var client: BitcoinFeesClient

    @Test
    fun beanNotNull() {
        assertThat(client).isNotNull
    }

    @Test
    fun fees() {
        val res = client.fees()
        assertThat(res).isNotNull
        assertThat(res.fastestFee).isNotNull()
        assertThat(res.halfHourFee).isNotNull()
        assertThat(res.hourFee).isNotNull()
    }
}