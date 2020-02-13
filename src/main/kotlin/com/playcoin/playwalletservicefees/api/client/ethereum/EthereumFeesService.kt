package com.playcoin.playwalletservicefees.api.client.ethereum

import retrofit2.Call
import retrofit2.http.GET

interface EthereumFeesService {
    @GET("/json/ethgasAPI.json")
    fun ethgas(): Call<EthereumFeesRes>
}