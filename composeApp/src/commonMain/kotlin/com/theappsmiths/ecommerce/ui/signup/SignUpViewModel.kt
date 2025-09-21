package com.theappsmiths.ecommerce.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(private val onboardingRepository: OnboardingRepository) : ViewModel() {

    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState: StateFlow<SignUpUiState> = _signUpUiState.asStateFlow()

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            _signUpUiState.update { currentState ->
                currentState.copy(isLoading = true)
            }
            val signUpResult = onboardingRepository.signUp(email, password)
            _signUpUiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    signUpResult = signUpResult,
                )
            }
        }
    }
}
