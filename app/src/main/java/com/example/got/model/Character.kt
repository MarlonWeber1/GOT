package com.example.got.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character (
    @SerializedName ("id") val idCharacter: String,
    @SerializedName ("firstName") val firstName: String,
    @SerializedName ("lastName") val lastName: String,
    @SerializedName ("fullName") val fullName: String,
    @SerializedName ("title") val title: String,
    @SerializedName ("family") val family: String,
    @SerializedName ("image") val image: String,
    @SerializedName ("imageUrl") val imageUrl: String
    ):Serializable
