package com.playcoin.playwalletservicefees.api.client.bitcoin

interface BitcoinFeesClient {
    fun fees(): BitcoinFeesRes
}