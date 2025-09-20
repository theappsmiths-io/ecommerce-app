package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeUsers
import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.RegistrationResult
import com.theappsmiths.ecommerce.domain.repository.LoginRepository

class FakeLoginRepositoryImpl : LoginRepository {
    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        return when {
            fakeUsers.any { it.email == email && it.password == password } -> LoginResult.Success
            else -> LoginResult.InvalidCredentials
        }
    }

    override suspend fun register(
        email: String,
        password: String
    ): RegistrationResult {
        return RegistrationResult.Success
    }
}
