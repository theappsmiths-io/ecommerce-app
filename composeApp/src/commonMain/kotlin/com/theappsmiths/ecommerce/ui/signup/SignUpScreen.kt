package com.theappsmiths.ecommerce.ui.signup

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
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = koinViewModel(),
    onSignUpSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    val signUpUiState by viewModel.signUpUiState.collectAsStateWithLifecycle()
    SignUpScreen(
        modifier = modifier,
        emailInputFieldState = signUpUiState.emailField,
        passwordInputFieldState = signUpUiState.passwordField,
        onSignUpClick = { email, password -> viewModel.signUp(email, password) },
        onNavigateToLogin = onNavigateToLogin
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onSignUpClick: (email: String, password: String) -> Unit,
    onNavigateToLogin: () -> Unit,
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

            SignUpSection(
                emailInputFieldState = emailInputFieldState,
                passwordInputFieldState = passwordInputFieldState,
                onSignUpClick = onSignUpClick,
                onNavigateToLogin = onNavigateToLogin,
            )
        }
    }
}
