package com.theappsmiths.ecommerce.ui.login


import com.theappsmiths.designsystem.ui.field.InputFieldState
import com.theappsmiths.designsystem.ui.field.emailStateValidator
import com.theappsmiths.designsystem.ui.field.passwordStateValidator
import com.theappsmiths.ecommerce.domain.model.LoginResult
import com.theappsmiths.ecommerce.domain.model.RegistrationResult

data class LoginUiState(
    val emailField: InputFieldState = InputFieldState(validator = emailStateValidator),
    val passwordField: InputFieldState = InputFieldState(validator = passwordStateValidator),
    val isLoading: Boolean = false,
    val loginResult: LoginResult? = null,
)

data class RegistrationUiState(
    val emailField: InputFieldState = InputFieldState(validator = emailStateValidator),
    val passwordField: InputFieldState = InputFieldState(validator = passwordStateValidator),
    val isLoading: Boolean = false,
    val registrationResult: RegistrationResult? = null,
)
