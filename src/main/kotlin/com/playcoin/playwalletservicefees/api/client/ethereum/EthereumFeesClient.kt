package com.playcoin.playwalletservicefees.api.client.ethereum

import com.playcoin.playwalletservicefees.api.client.bitcoin.BitcoinFeesRes

interface EthereumFeesClient {
    fun fees(): EthereumFeesRes
}