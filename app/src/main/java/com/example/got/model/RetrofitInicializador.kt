package com.example.got.model

import com.example.got.model.interfaces.GameOfThronesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInicializador {
    private val BASE_URL  = "https://thronesapi.com/swagger/index.html?urls.primaryName=Game%20of%20Thrones%20API%20v2"

    val charactersService : GameOfThronesService
    val continentService : GameOfThronesService

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        charactersService = retrofit.create(GameOfThronesService::class.java)
    }

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        continentService = retrofit.create(GameOfThronesService::class.java)
    }


}