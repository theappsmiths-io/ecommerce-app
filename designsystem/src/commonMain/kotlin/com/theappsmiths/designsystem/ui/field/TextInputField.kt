package com.theappsmiths.designsystem.ui.field

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ecommerce.designsystem.generated.resources.Res
import ecommerce.designsystem.generated.resources.cd_toggle_password_visibility
import ecommerce.designsystem.generated.resources.error_email_invalid
import ecommerce.designsystem.generated.resources.error_password_invalid
import ecommerce.designsystem.generated.resources.hint_email
import ecommerce.designsystem.generated.resources.hint_password
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
) {
    val hasError = emailInputFieldState.getValidationState() == ValidationState.INVALID

    OutlinedTextField(
        state = emailInputFieldState.textFieldState,
        modifier = modifier,
        lineLimits = TextFieldLineLimits.SingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
        label = { Text(stringResource(Res.string.hint_email)) },
        placeholder = { Text(stringResource(Res.string.hint_email)) },
        shape = RoundedCornerShape(8.dp),
        isError = hasError,
        supportingText = {
            if (hasError) {
                Text(
                    text = when (emailInputFieldState.getValidationState()) {
                        ValidationState.INVALID -> stringResource(Res.string.error_email_invalid)
                        ValidationState.VALID, ValidationState.INITIAL -> ""
                    },
                    color = MaterialTheme.colorScheme.error,
                )
            }
        }
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    passwordInputFieldState: InputFieldState,
    onKeyboardActionClicked: () -> Unit = { },
) {
    val hasError = passwordInputFieldState.getValidationState() == ValidationState.INVALID
    var showPassword by rememberSaveable { mutableStateOf(false) }

    OutlinedSecureTextField(
        state = passwordInputFieldState.textFieldState,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        textObfuscationMode =
            if (showPassword) {
                TextObfuscationMode.Visible
            } else {
                TextObfuscationMode.RevealLastTyped
            },
        label = { Text(stringResource(Res.string.hint_password)) },
        placeholder = { Text(stringResource(Res.string.hint_password)) },
        trailingIcon = {
            Icon(
                if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                contentDescription = stringResource(Res.string.cd_toggle_password_visibility),
                modifier = Modifier.clickable { showPassword = !showPassword }
            )
        },
        isError = hasError,
        supportingText = {
            if (hasError) {
                Text(
                    text = when (passwordInputFieldState.getValidationState()) {
                        ValidationState.INVALID -> stringResource(Res.string.error_password_invalid)
                        ValidationState.INITIAL, ValidationState.VALID -> ""
                    },
                    color = MaterialTheme.colorScheme.error,
                )
            }
        },
        onKeyboardAction = { performDefaultAction ->
            onKeyboardActionClicked()
            performDefaultAction()
        },
    )
}
