package com.playcoin.playwalletservicefees.api.service.impl

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesClient
import com.playcoin.playwalletservicefees.api.client.ethereum.EthereumFeesClient
import com.playcoin.playwalletservicefees.api.domain.Fee
import com.playcoin.playwalletservicefees.api.service.FeeService
import com.playcoin.playwalletservicefees.enums.CoinType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class FeeServiceImpl: FeeService {

    @Autowired
    lateinit var bitcoinFeesClient: BitcoinFeesClient

    @Autowired
    lateinit var ethereumFeesClient: EthereumFeesClient

    override fun fees(coinType: CoinType): Result<Fee> = kotlin.run {
        when(coinType) {
            CoinType.BTC -> bitcoinFees()
            CoinType.ETH -> ethereumFees()
            CoinType.PLY -> Result.failure(RuntimeException("Not implementation: PLY Fees"))
            CoinType.PLX -> Result.failure(RuntimeException("Not implementation: PLX Fees"))
            CoinType.DMY -> Result.failure(RuntimeException("Not implementation: DMY Fees"))
        }
    }

    fun bitcoinFees(): Result<Fee> = bitcoinFeesClient.fees().runCatching {
        Fee(slow = this.hourFee, normal = this.halfHourFee, fast = this.fastestFee)
    }

    fun ethereumFees(): Result<Fee> = ethereumFeesClient.fees().runCatching {
        Fee(slow = this.safeLow, normal = this.average, fast = this.fast)
    }

}