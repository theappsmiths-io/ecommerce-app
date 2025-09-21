package com.theappsmiths.ecommerce.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theappsmiths.designsystem.ui.field.InputFieldState
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.app_name
import ecommerce.composeapp.generated.resources.img_island_combo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    val loginUiState by viewModel.loginUiState.collectAsStateWithLifecycle()

    LoginScreen(
        modifier = modifier,
        emailInputFieldState = loginUiState.emailField,
        passwordInputFieldState = loginUiState.passwordField,
        onLoginClicked = { email, password -> viewModel.login(email, password) },
        onForgotPasswordClicked = {},
        onSignUpClick = onSignUpClick,
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onLoginClicked: (email: String, password: String) -> Unit,
    onForgotPasswordClicked: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Scaffold(modifier = modifier) { contentPadding ->
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(Res.drawable.img_island_combo),
                contentDescription = stringResource(Res.string.app_name),
                modifier = Modifier
                    .height(160.dp)
                    .width(IntrinsicSize.Min),
                contentScale = ContentScale.Fit,
            )

            Spacer(modifier = Modifier.height(32.dp))

            LoginSection(
                emailInputFieldState = emailInputFieldState,
                passwordInputFieldState = passwordInputFieldState,
                onLoginClick = onLoginClicked,
                onForgotPasswordClick = onForgotPasswordClicked,
                onSignUpClick = onSignUpClick,
            )
        }
    }
}
