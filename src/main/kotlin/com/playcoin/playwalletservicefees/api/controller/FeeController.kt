package com.playcoin.playwalletservicefees.api.controller

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesClient
import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesRes
import com.playcoin.playwalletservicefees.api.domain.Fee
import com.playcoin.playwalletservicefees.api.domain.FeeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException
import java.math.BigDecimal

@RestController
@RequestMapping("/fees")
class FeeController {

    @Autowired
    lateinit var bitcoinFeesClient: BitcoinFeesClient

    @GetMapping
    fun fees(): FeeResponse = FeeResponse.fromResult(bitcoinFees())

    fun bitcoinFees(): Result<Fee> = bitcoinFeesClient.fees().runCatching {
        Fee(slow = this.hourFee, normal = this.halfHourFee, fast = this.fastestFee)
    }
}
