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
import com.theappsmiths.designsystem.ui.button.HighlightTextButton
import com.theappsmiths.designsystem.ui.button.GoogleLoginButton
import com.theappsmiths.designsystem.ui.button.mediumSize
import com.theappsmiths.designsystem.ui.divider.TextDivider
import com.theappsmiths.designsystem.ui.field.EmailTextField
import com.theappsmiths.designsystem.ui.field.InputFieldState
import com.theappsmiths.designsystem.ui.field.PasswordTextField
import com.theappsmiths.designsystem.ui.field.emailStateValidator
import com.theappsmiths.designsystem.ui.field.passwordStateValidator
import com.theappsmiths.designsystem.ui.theme.AppTheme
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.button_forgot_password
import ecommerce.composeapp.generated.resources.header_login
import ecommerce.composeapp.generated.resources.button_login
import ecommerce.composeapp.generated.resources.label_login_divider
import ecommerce.composeapp.generated.resources.redirect_signup_highlight
import ecommerce.composeapp.generated.resources.redirect_signup_text
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoginSection(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onLoginClick: (email: String, password: String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    val areInputsValid = emailInputFieldState.isValid() && passwordInputFieldState.isValid()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.header_login),
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(24.dp))

        EmailTextField(
            modifier = Modifier.fillMaxWidth(),
            emailInputFieldState = emailInputFieldState,
        )

        Spacer(modifier = Modifier.height(8.dp))

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            passwordInputFieldState = passwordInputFieldState,
            onKeyboardActionClicked = {
                onLoginClick(
                    emailInputFieldState.textFieldState.text.toString(),
                    passwordInputFieldState.textFieldState.text.toString(),
                )
            }
        )
        TextButton(
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.textButtonColors()
                .copy(contentColor = MaterialTheme.colorScheme.onSurface),
            onClick = onForgotPasswordClick
        ) {
            Text(
                text = stringResource(Res.string.button_forgot_password),
                style = MaterialTheme.typography.bodySmall,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            enabled = areInputsValid,
            contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
            onClick = {
                onLoginClick(
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

        Spacer(modifier = Modifier.height(16.dp))

        TextDivider(text = stringResource(Res.string.label_login_divider))

        Spacer(modifier = Modifier.height(16.dp))

        GoogleLoginButton { }

        Spacer(modifier = Modifier.height(8.dp))

        AppleLoginButton { }

        Spacer(modifier = Modifier.height(24.dp))

        HighlightTextButton(
            text = stringResource(Res.string.redirect_signup_text),
            textToHighlight = stringResource(Res.string.redirect_signup_highlight),
            onClick = onSignUpClick,
        )
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
                onLoginClick = { _, _ -> },
                onForgotPasswordClick = { },
                onSignUpClick = {}
            )
        }
    }
}
