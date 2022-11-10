package com.example.got.model.error

import java.lang.Exception

object ApiError {
    data class GenericException(override val message: String? = null) : Exception()
}