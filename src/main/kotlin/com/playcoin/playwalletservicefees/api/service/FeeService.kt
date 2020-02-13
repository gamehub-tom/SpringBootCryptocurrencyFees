package com.playcoin.playwalletservicefees.api.service

import com.playcoin.playwalletservicefees.api.domain.Fee
import com.playcoin.playwalletservicefees.enums.CoinType

interface FeeService {
    fun fees(coinType: CoinType): Result<Fee>
}
