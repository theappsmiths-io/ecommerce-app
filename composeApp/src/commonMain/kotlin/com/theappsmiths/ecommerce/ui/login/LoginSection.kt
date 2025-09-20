package com.theappsmiths.ecommerce.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.theappsmiths.designsystem.ui.button.AppleLoginButton
import com.theappsmiths.designsystem.ui.button.GoogleLoginButton
import com.theappsmiths.designsystem.ui.button.mediumSize
import com.theappsmiths.designsystem.ui.field.EmailTextField
import com.theappsmiths.designsystem.ui.field.InputFieldState
import com.theappsmiths.designsystem.ui.field.PasswordTextField
import com.theappsmiths.designsystem.ui.field.emailStateValidator
import com.theappsmiths.designsystem.ui.field.passwordStateValidator
import com.theappsmiths.designsystem.ui.theme.AppTheme
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.button_forgot_password
import ecommerce.composeapp.generated.resources.button_login
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoginSection(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onLoginClicked: (email: String, password: String) -> Unit,
    onForgotPasswordClicked: () -> Unit,
) {
    val areInputsValid = emailInputFieldState.isValid() && passwordInputFieldState.isValid()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EmailTextField(
            modifier = Modifier.fillMaxWidth(),
            emailInputFieldState = emailInputFieldState,
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            passwordInputFieldState = passwordInputFieldState,
            onKeyboardActionClicked = {
                onLoginClicked(
                    emailInputFieldState.textFieldState.text.toString(),
                    passwordInputFieldState.textFieldState.text.toString(),
                )
            }
        )
        TextButton(
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.textButtonColors()
                .copy(contentColor = MaterialTheme.colorScheme.primary),
            onClick = onForgotPasswordClicked
        ) {
            Text(
                text = stringResource(Res.string.button_forgot_password),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            enabled = areInputsValid,
            contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
            onClick = {
                onLoginClicked(
                    emailInputFieldState.textFieldState.text.toString(),
                    passwordInputFieldState.textFieldState.text.toString(),
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                stringResource(Res.string.button_login),
                style = MaterialTheme.typography.labelLarge,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        GoogleLoginButton { }

        Spacer(modifier = Modifier.height(8.dp))

        AppleLoginButton { }
    }
}

@Preview
@Composable
fun LoginSectionPreview() {
    AppTheme {
        Surface {
            LoginSection(
                emailInputFieldState = InputFieldState(validator = emailStateValidator),
                passwordInputFieldState = InputFieldState(validator = passwordStateValidator),
                onLoginClicked = { _, _ -> },
                onForgotPasswordClicked = { },
            )
        }
    }
}
