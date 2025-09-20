package com.theappsmiths.ecommerce.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theappsmiths.designsystem.ui.field.InputFieldState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
) {
    val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()
    val registrationUiState by loginViewModel.registrationUiState.collectAsStateWithLifecycle()
    LoginScreen(
        modifier = modifier,
        emailInputFieldState = loginUiState.emailField,
        passwordInputFieldState = loginUiState.passwordField,
        onLoginClicked = { _, _ -> },
        onForgotPasswordClicked = {},
        onRegisterClicked = { _, _ -> },
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onLoginClicked: (email: String, password: String) -> Unit,
    onForgotPasswordClicked: () -> Unit,
    onRegisterClicked: (email: String, password: String) -> Unit,
) {
    Scaffold { contentPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(contentPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LoginSection(
                emailInputFieldState = emailInputFieldState,
                passwordInputFieldState = passwordInputFieldState,
                onLoginClicked = onLoginClicked,
                onForgotPasswordClicked = onForgotPasswordClicked,
            )
        }
    }
}
