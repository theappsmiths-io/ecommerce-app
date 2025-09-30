package com.theappsmiths.ecommerce.ui.login

import com.theappsmiths.designsystem.ui.field.InputFieldState
import com.theappsmiths.designsystem.ui.field.emailStateValidator
import com.theappsmiths.designsystem.ui.field.passwordStateValidator

data class LoginUiState(
    val emailField: InputFieldState = InputFieldState(validator = emailStateValidator),
    val passwordField: InputFieldState = InputFieldState(validator = passwordStateValidator),
    val isLoading: Boolean = false,
    val loginEvent: LoginEvent? = null,
)
