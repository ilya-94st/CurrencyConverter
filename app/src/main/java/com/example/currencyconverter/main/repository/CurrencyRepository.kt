package com.example.currencyconverter.main.repository

import com.example.currencyconverter.api.Api
import com.example.currencyconverter.modules.CurrencyResponse
import com.example.currencyconverter.other.Resources
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val api: Api): MainRepository {
    override suspend fun getCurrency(base: String): Resources<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resources.Success(result)
            } else {
                Resources.Error(response.message())
            }
        } catch(e: Exception) {
            Resources.Error(e.message ?: "An error occured")
        }
    }
}