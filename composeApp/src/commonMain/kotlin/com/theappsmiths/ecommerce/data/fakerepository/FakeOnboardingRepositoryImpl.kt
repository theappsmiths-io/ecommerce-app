package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeUsers
import com.theappsmiths.ecommerce.domain.model.SignUpResult
import com.theappsmiths.ecommerce.domain.model.error.LoginError
import com.theappsmiths.ecommerce.domain.model.result.Result
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository
import kotlinx.coroutines.delay

class FakeOnboardingRepositoryImpl : OnboardingRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<Unit, LoginError> {
        delay(2000)
        return when {
            fakeUsers.any { it.email == email && it.password == password } -> Result.Success(Unit)
            else -> Result.Error(error = LoginError.InvalidCredentials)
        }
    }

    override suspend fun signUp(
        email: String,
        password: String
    ): SignUpResult {
        return SignUpResult.Success
    }
}
