package com.theappsmiths.ecommerce.domain.model.error

sealed interface ApiError : Error {
    data class Server(val code: Int, val message: String) : ApiError
    data class Client(val code: Int, val message: String) : ApiError
    data class Unknown(val message: String) : ApiError
}
