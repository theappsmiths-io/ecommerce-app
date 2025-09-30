package com.theappsmiths.ecommerce.domain.model.error

sealed interface LoginError : Error {
    data object InvalidCredentials : LoginError
    data class Api(val error: ApiError) : LoginError
}
