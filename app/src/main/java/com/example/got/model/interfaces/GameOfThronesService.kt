package com.example.got.model.interfaces

import com.example.got.model.response.CharacterResponse
import com.example.got.model.response.ContinentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameOfThronesService {

    @GET("/api/v2/Characters")
    suspend fun searchCharactersByList(): Response<CharacterResponse>

    @GET("/api/v2/Continents")
    suspend fun searchContinentsByList(): Response<ContinentResponse>

}