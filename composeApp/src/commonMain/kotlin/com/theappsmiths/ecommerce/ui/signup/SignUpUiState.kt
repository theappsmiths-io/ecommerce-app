package com.theappsmiths.ecommerce.ui.signup

import com.theappsmiths.designsystem.ui.field.InputFieldState
import com.theappsmiths.designsystem.ui.field.emailStateValidator
import com.theappsmiths.designsystem.ui.field.passwordStateValidator
import com.theappsmiths.ecommerce.domain.model.SignUpResult

data class SignUpUiState(
    val emailField: InputFieldState = InputFieldState(validator = emailStateValidator),
    val passwordField: InputFieldState = InputFieldState(validator = passwordStateValidator),
    val isLoading: Boolean = false,
    val signUpResult: SignUpResult? = null,
)
