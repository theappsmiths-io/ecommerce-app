package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.domain.repository.OtpRepository

class OtpRepositoryImpl: OtpRepository {
    override fun verifyOtp(otpCode: String): Boolean {
        //TODO update this once API is ready
        return true
    }

    override fun resendOtp(): Boolean {
        //TODO update this once API is ready
        return true
    }
}
