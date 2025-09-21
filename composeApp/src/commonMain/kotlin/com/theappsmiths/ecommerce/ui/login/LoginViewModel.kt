package com.theappsmiths.ecommerce.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginUiState.update { currentState ->
                currentState.copy(isLoading = true)
            }
            val loginResult = loginRepository.login(email, password)
            _loginUiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    loginResult = loginResult,
                )
            }
        }
    }
}
