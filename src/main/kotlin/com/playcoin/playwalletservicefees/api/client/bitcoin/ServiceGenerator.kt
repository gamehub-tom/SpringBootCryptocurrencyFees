package com.playcoin.playwalletservicefees.api.client.bitcoin

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator(host: String, port: Int) {

    init {
        require(host.isNotEmpty())
        require((0..655335).contains(port))
    }

    val httpClient = OkHttpClient.Builder()
    val API_URL =  if (port == 0) host else "$host:$port"

    init {
        // HTTP logging
        // httpClient.addInterceptor(HttpLoggingInterceptor().setLevel())

        // user agent header
        httpClient.addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                .header("User-Agent", "").build())
        }
    }

    inline fun <reified S> createService(): S = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build()).build().create(S::class.java)
}