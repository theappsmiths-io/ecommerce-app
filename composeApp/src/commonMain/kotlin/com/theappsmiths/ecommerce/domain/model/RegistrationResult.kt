package com.theappsmiths.ecommerce.domain.model

sealed class RegistrationResult {
    data object Success : RegistrationResult()
    data class Error(val message: String) : RegistrationResult()
    data object NetworkError : RegistrationResult()
    data object DoesNotMatch : RegistrationResult()
    data object DoesNotExist : RegistrationResult()
}
