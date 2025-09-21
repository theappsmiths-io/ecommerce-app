package com.theappsmiths.ecommerce.domain.model

sealed class SignUpResult {
    data object Success : SignUpResult()
    data class Error(val message: String) : SignUpResult()
    data object NetworkError : SignUpResult()
    data object DoesNotMatch : SignUpResult()
    data object DoesNotExist : SignUpResult()
}
