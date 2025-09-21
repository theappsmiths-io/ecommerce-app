package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeUsers
import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.SignUpResult
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository

class OnboardingRepositoryImpl : OnboardingRepository {
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

    override suspend fun signUp(
        email: String,
        password: String
    ): SignUpResult {
        //TODO update this once API is ready
        return SignUpResult.Success
    }
}
