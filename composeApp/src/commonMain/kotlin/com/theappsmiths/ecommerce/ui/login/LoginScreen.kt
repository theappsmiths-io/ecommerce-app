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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theappsmiths.designsystem.ui.dialog.SimpleAlertDialog
import com.theappsmiths.designsystem.ui.field.InputFieldState
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.app_name
import ecommerce.composeapp.generated.resources.dialog_check_credentials
import ecommerce.composeapp.generated.resources.dialog_check_network
import ecommerce.composeapp.generated.resources.dialog_invalid_credentials
import ecommerce.composeapp.generated.resources.dialog_network_error
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
    var showDialog by rememberSaveable() { mutableStateOf(false) }
    var dialogTitleResId by remember { mutableStateOf(Res.string.dialog_invalid_credentials) }
    var dialogTextResId by remember { mutableStateOf(Res.string.dialog_check_credentials) }

    LaunchedEffect(loginUiState.loginEvent) {
        when (loginUiState.loginEvent) {
            LoginEvent.LoginSuccessful -> onLoginSuccess()

            LoginEvent.InvalidCredentials -> {
                dialogTitleResId = Res.string.dialog_invalid_credentials
                dialogTextResId = Res.string.dialog_check_credentials
                showDialog = true
            }

            LoginEvent.NetworkError -> {
                dialogTitleResId = Res.string.dialog_network_error
                dialogTextResId = Res.string.dialog_check_network
                showDialog = true
            }
            null -> { /* Do nothing */ }
        }
        viewModel.loginEventConsumed()
    }

    if (showDialog) {
        SimpleAlertDialog(
            title = stringResource(dialogTitleResId),
            text = stringResource(dialogTextResId),
            onDismiss = { showDialog = false }
        )
    }

    LoginScreen(
        modifier = modifier,
        isLoading = loginUiState.isLoading,
        emailInputFieldState = loginUiState.emailField,
        passwordInputFieldState = loginUiState.passwordField,
        onLoginClick = { email, password -> viewModel.login(email, password) },
        onForgotPasswordClicked = {},
        onSignUpClick = onSignUpClick,
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onLoginClick: (email: String, password: String) -> Unit,
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
                isLoading = isLoading,
                emailInputFieldState = emailInputFieldState,
                passwordInputFieldState = passwordInputFieldState,
                onLoginClick = onLoginClick,
                onForgotPasswordClick = onForgotPasswordClicked,
                onSignUpClick = onSignUpClick,
            )
        }
    }
}
