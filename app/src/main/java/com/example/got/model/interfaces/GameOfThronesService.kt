package com.example.got.model.interfaces

import com.example.got.model.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameOfThronesService {

    @GET("/api/v2/Characters")
    suspend fun buscaCharacters(): Response<CharacterResponse>


}