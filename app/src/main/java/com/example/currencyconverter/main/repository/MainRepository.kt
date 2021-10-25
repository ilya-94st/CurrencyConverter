package com.example.currencyconverter.main.repository

import com.example.currencyconverter.modules.CurrencyResponse
import com.example.currencyconverter.other.Resources

interface MainRepository {
    suspend fun getCurrency(base: String): Resources<CurrencyResponse>
}