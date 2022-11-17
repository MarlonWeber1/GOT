package com.example.got.repository

import com.example.got.model.error.ApiError
import com.example.got.model.interfaces.GameOfThronesService
import com.example.got.model.response.CharacterResponse
import com.example.got.model.response.ContinentResponse
import com.example.got.model.response.NetworkResponse

class RepositoryIpl(val api: GameOfThronesService) : Repository {

    override suspend fun catchCharacters(): NetworkResponse<CharacterResponse> {
        return try {
            val response = api.searchCharactersByList()
            if (response.isSuccessful) {
                NetworkResponse.Success(response.body()!!)
            } else {
                NetworkResponse.Failed(Exception())
            }
        } catch (e: Exception) {
            NetworkResponse.Failed(ApiError.GenericException())
        }
    }

    override suspend fun catchContinents(): NetworkResponse<ContinentResponse> {
        return try {
            val response = api.searchContinentsByList()
            if (response.isSuccessful){
                NetworkResponse.Success(response.body()!!)
            }else{
                NetworkResponse.Failed(Exception())
            }
        }catch (e: Exception){
            NetworkResponse.Failed(ApiError.GenericException())
        }
    }

}

interface Repository {
    suspend fun catchCharacters(): NetworkResponse<CharacterResponse>
    suspend fun catchContinents(): NetworkResponse<ContinentResponse>
}