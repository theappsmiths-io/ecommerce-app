package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.domain.repository.OtpRepository

class FakeOtpRepositoryImpl : OtpRepository {
    override fun verifyOtp(otpCode: String): Boolean {
        return true
    }

    override fun resendOtp(): Boolean {
        return true
    }
}