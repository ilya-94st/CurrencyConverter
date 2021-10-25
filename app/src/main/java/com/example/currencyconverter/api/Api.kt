package com.example.currencyconverter.api

import com.example.currencyconverter.modules.CurrencyResponse
import com.example.currencyconverter.other.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1/latest")
    suspend fun getRates(
        @Query("base")
        base: String = "",
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<CurrencyResponse>

}