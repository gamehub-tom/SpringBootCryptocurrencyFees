package com.playcoin.playwalletservicefees.api.controller

import com.playcoin.playwalletservicefees.api.domain.FeeResponse
import com.playcoin.playwalletservicefees.api.service.FeeService
import com.playcoin.playwalletservicefees.enums.CoinType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FeeController(@Autowired val feeService: FeeService) {

    @GetMapping("/{coinType}/fees")
    fun btcFees(@PathVariable coinType: CoinType): FeeResponse
        = FeeResponse.fromResult(feeService.fees(coinType = coinType))

}
