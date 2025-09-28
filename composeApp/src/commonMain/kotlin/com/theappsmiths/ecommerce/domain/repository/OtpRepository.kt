package com.theappsmiths.ecommerce.domain.repository

interface OtpRepository {
    fun verifyOtp(otpCode: String): Boolean

    fun resendOtp(): Boolean
}
