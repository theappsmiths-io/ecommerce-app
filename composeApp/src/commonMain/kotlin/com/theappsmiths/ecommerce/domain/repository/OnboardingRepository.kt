package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.SignUpResult
import com.theappsmiths.ecommerce.domain.model.error.LoginError
import com.theappsmiths.ecommerce.domain.model.result.Result

interface OnboardingRepository {

    suspend fun login(email: String, password: String): Result<Unit, LoginError>

    suspend fun signUp(email: String, password: String): SignUpResult
}
