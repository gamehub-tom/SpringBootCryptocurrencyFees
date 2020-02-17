package com.playcoin.playwalletservicefees.api.service.impl

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesClient
import com.playcoin.playwalletservicefees.api.client.ethereum.EthereumFeesClient
import com.playcoin.playwalletservicefees.api.domain.Fee
import com.playcoin.playwalletservicefees.api.service.FeeService
import com.playcoin.playwalletservicefees.enums.CoinType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.max

@Service
class FeeServiceImpl(
        @Autowired val bitcoinFeesClient: BitcoinFeesClient,
        @Autowired val ethereumFeesClient: EthereumFeesClient
): FeeService {

    override fun fees(coinType: CoinType): Result<Fee> = kotlin.run {
        when(coinType) {
            CoinType.BTC -> bitcoinFees()
            CoinType.ETH -> ethereumFees()
            CoinType.PLY -> playcoinFees()
            CoinType.PLX -> playcoinFees()
            CoinType.DMY -> Result.failure(RuntimeException("Not implementation: DMY Fees"))
        }
    }

    fun bitcoinFees(): Result<Fee> = bitcoinFeesClient.fees().runCatching {
        val minimum = BigDecimal(1000)      // 0.00001
        val maximum = BigDecimal(10000)     // 0.0001
        val fixedBaseFee = BigDecimal(250)
        val slow = minimum.max(this.hourFee * fixedBaseFee)
        val fast = maximum.max(this.fastestFee * fixedBaseFee)
        Fee(slow = slow, normal = fast.half(slow), fast = fast, gasLimit = null)
    }

    fun ethereumFees(): Result<Fee> = ethereumFeesClient.fees().runCatching {
        val minimum = BigDecimal(5)     // 0.00001
        val maximum = BigDecimal(20)    // 0.0001
        val fixedBaseFee = BigDecimal(0.2)
        val gasLimit = BigDecimal(21000)
        val slow = minimum.max(this.safeLow * fixedBaseFee).setScale(0, RoundingMode.HALF_EVEN)
        val fast = maximum.max(this.fast * fixedBaseFee).setScale(0, RoundingMode.HALF_EVEN)
        Fee(slow = slow, normal = fast.half(slow), fast = fast, gasLimit = gasLimit)
    }

    fun playcoinFees(): Result<Fee> = ethereumFeesClient.fees().runCatching {
        val minimum = BigDecimal(5)     // 5 gwei
        val maximum = BigDecimal(20)    // 20 gwei
        val fixedBaseFee = BigDecimal(0.2)
        val gasLimit = BigDecimal(79258)
        val slow = minimum.max(this.safeLow * fixedBaseFee).setScale(0, RoundingMode.HALF_EVEN)
        val fast = maximum.max(this.fast * fixedBaseFee).setScale(0, RoundingMode.HALF_EVEN)
        Fee(slow = slow, normal = fast.half(slow), fast = fast, gasLimit = gasLimit)
    }

    fun BigDecimal.half(a: BigDecimal): BigDecimal {
        val smaller = minOf(this, a)
        val bigger = maxOf(this, a)
        val result = (bigger - smaller).div(BigDecimal(2)) + smaller
        return result.setScale(0, RoundingMode.HALF_EVEN)
    }
}