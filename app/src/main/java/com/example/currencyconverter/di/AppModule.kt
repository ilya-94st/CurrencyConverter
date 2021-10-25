package com.example.currencyconverter.di

import com.example.currencyconverter.api.Api
import com.example.currencyconverter.main.repository.CurrencyRepository
import com.example.currencyconverter.main.repository.MainRepository
import com.example.currencyconverter.other.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
     fun provideCurrencyApi(): Api = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    @Provides
    @Singleton
    fun provideMainRepository(api: Api): MainRepository = CurrencyRepository(api)

}