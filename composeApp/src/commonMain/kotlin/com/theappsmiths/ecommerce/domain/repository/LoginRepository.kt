package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.RegistrationResult

interface LoginRepository {

    suspend fun login(email: String, password: String): LoginResult

    suspend fun register(email: String, password: String): RegistrationResult
}
