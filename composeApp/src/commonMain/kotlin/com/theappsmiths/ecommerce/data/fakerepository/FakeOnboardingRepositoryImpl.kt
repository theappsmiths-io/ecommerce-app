package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeUsers
import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.SignUpResult
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository

class FakeOnboardingRepositoryImpl : OnboardingRepository {
    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        return when {
            fakeUsers.any { it.email == email && it.password == password } -> LoginResult.Success
            else -> LoginResult.InvalidCredentials
        }
    }

    override suspend fun signUp(
        email: String,
        password: String
    ): SignUpResult {
        return SignUpResult.Success
    }
}
