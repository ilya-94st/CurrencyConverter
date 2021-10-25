package com.example.currencyconverter.modules

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Rates
)