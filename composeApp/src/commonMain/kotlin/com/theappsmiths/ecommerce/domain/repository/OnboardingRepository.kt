package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.SignUpResult

interface OnboardingRepository {

    suspend fun login(email: String, password: String): LoginResult

    suspend fun signUp(email: String, password: String): SignUpResult
}
