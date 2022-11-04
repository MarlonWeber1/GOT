package com.example.got.model

import com.google.gson.annotations.SerializedName

data class Continent (
    @SerializedName("id") val idContinent: String,
    @SerializedName("name") val name: String
)