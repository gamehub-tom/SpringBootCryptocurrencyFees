package com.playcoin.playwalletservicefees.api.client.bitcoin

import retrofit2.Call
import retrofit2.http.GET

interface BitcoinFeesService {
    @GET("/api/v1/fees/recommended")
    fun recommended(): Call<BitcoinFeesRes>
}