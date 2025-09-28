package com.theappsmiths.ecommerce.ui.emailverification.verifyotp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.repository.OtpRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VerifyOtpViewModel(val otpRepository: OtpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(VerifyOtpUiState())
    val uiState: StateFlow<VerifyOtpUiState> = _uiState.asStateFlow()

    private val _countdown = MutableStateFlow(30)
    val countdown: StateFlow<Int> = _countdown.asStateFlow()

    fun verifyOtp() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val isOtpVerified = otpRepository.verifyOtp(otpCode = _uiState.value.otpState.text.toString())
            _uiState.update { it.copy(isLoading = false, isOtpVerified = isOtpVerified) }

        }

    }
    fun resendOtp() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val isOtpResent = otpRepository.resendOtp()
            _uiState.update { it.copy(isLoading = false, isOtpResent = isOtpResent) }
        }
    }
}
