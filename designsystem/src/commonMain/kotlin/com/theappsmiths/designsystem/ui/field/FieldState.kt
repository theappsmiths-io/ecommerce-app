package com.theappsmiths.designsystem.ui.field

import androidx.compose.foundation.text.input.TextFieldState

enum class ValidationState {
    INITIAL, INVALID, VALID,
}

data class InputFieldState(
    val textFieldState: TextFieldState = TextFieldState(),
    private val validator: StateValidator,
) {
    fun getValidationState(): ValidationState {
        return validator(textFieldState.text.toString())
    }

    fun isValid(): Boolean {
        return getValidationState() == ValidationState.VALID
    }
}

typealias StateValidator = (input: String) -> ValidationState


private const val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
private val EMAIL_PATTERN = EMAIL_REGEX.toRegex()
val emailStateValidator: StateValidator = { email ->
    when {
        email.isEmpty() -> ValidationState.INITIAL
        (EMAIL_PATTERN.matches(email)) -> ValidationState.VALID
        else -> ValidationState.INVALID
    }
}

val passwordStateValidator: StateValidator = { password ->
    when {
        password.isEmpty() -> ValidationState.INITIAL
        else -> ValidationState.VALID
    }
}
