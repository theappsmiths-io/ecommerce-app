package com.theappsmiths.ecommerce.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.model.error.LoginError
import com.theappsmiths.ecommerce.domain.model.result.Result
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val onboardingRepository: OnboardingRepository) : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginUiState.update { currentState ->
                currentState.copy(isLoading = true)
            }
            val loginResult = onboardingRepository.login(email, password)
            when (loginResult) {
                is Result.Success -> {
                    _loginUiState.update {
                        it.copy(
                            isLoading = false,
                            loginEvent = LoginEvent.LoginSuccessful,
                        )
                    }
                }
                is Result.Error -> {
                    val error = loginResult.error
                    when (error) {
                        LoginError.InvalidCredentials -> {
                            _loginUiState.update {
                                it.copy(
                                    isLoading = false,
                                    loginEvent = LoginEvent.InvalidCredentials,
                                )
                            }
                        }
                        is LoginError.Api -> {
                            _loginUiState.update {
                                it.copy(
                                    isLoading = false,
                                    loginEvent = LoginEvent.NetworkError,
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun loginEventConsumed() {
        _loginUiState.update {
            it.copy(loginEvent = null)
        }
    }
}

sealed interface LoginEvent {
    object LoginSuccessful : LoginEvent
    object InvalidCredentials : LoginEvent
    object NetworkError : LoginEvent
}
