package com.playcoin.playwalletservicefees.api.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FeeServiceImplTest {

    @Autowired
    lateinit var feeService: FeeService

    @Test
    fun beanNotNull() {
        assertThat(feeService).isNotNull
    }

    @Test
    fun empty() {
        val fee = feeService.fees()
        assertThat(fee.isSuccess).isTrue()
    }
}
