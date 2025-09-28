package com.theappsmiths.ecommerce.ui.emailverification.verifyotp

import androidx.compose.foundation.text.input.TextFieldState

data class VerifyOtpUiState(
    val otpState: TextFieldState = TextFieldState(),
    val isLoading: Boolean = false,
    val isOtpVerified: Boolean? = null,
    val isOtpResent: Boolean? = null,
)
