package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeUsers
import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.RegistrationResult
import com.theappsmiths.ecommerce.domain.repository.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        //TODO update this once API is ready
        return when {
            fakeUsers.any { it.email == email && it.password == password } -> LoginResult.Success
            else -> LoginResult.InvalidCredentials
        }
    }

    override suspend fun register(
        email: String,
        password: String
    ): RegistrationResult {
        //TODO update this once API is ready
        return RegistrationResult.Success
    }
}
