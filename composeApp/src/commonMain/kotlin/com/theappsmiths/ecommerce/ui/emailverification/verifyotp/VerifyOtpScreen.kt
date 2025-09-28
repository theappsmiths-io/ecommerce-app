package com.theappsmiths.ecommerce.ui.emailverification.verifyotp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.theappsmiths.designsystem.ui.button.mediumSize
import com.theappsmiths.designsystem.ui.field.OtpTextField
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.button_resend_otp
import ecommerce.composeapp.generated.resources.button_verify_otp
import ecommerce.composeapp.generated.resources.img_email
import ecommerce.composeapp.generated.resources.verify_email_description
import ecommerce.composeapp.generated.resources.verify_email_enter_code
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VerifyOtpScreen(
    modifier: Modifier = Modifier,
    viewModel: VerifyOtpViewModel = koinViewModel(),
    navController: NavController,

) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val countdown by viewModel.countdown.collectAsStateWithLifecycle()

    VerifyOtpScreen(
        modifier = modifier,
        otpState = uiState.otpState,
        countdown = countdown.toString(),
        canNavigateBack = navController.previousBackStackEntry != null,
        onNavigateUp = { navController.navigateUp() },
        onVerifyOtpClick = { viewModel.verifyOtp() },
        onResendOtpClick = { viewModel.resendOtp() },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyOtpScreen(
    modifier: Modifier = Modifier,
    otpState: TextFieldState,
    countdown: String,
    canNavigateBack: Boolean,
    onNavigateUp: () -> Unit,
    onVerifyOtpClick: () -> Unit,
    onResendOtpClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { },
                modifier = modifier,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = onNavigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back button"
                            )
                        }
                    }
                },
            )
        }) { contentPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
        ) {

            VerificationCodeSection(
                modifier = Modifier.fillMaxWidth(),
                otpState = otpState
            )

            VerifyOtpButtonSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                countdown = countdown,
                onVerifyOtpClick = onVerifyOtpClick,
                onResendOtpClick = onResendOtpClick,
            )
        }
    }

}

@Composable
fun VerificationCodeSection(modifier: Modifier = Modifier, otpState: TextFieldState) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Image(
            painter = painterResource(Res.drawable.img_email),
            contentDescription = stringResource(Res.string.verify_email_enter_code),
            modifier = Modifier
                .height(132.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(Res.string.verify_email_enter_code),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = stringResource(Res.string.verify_email_description),
            style = MaterialTheme.typography.bodyMedium,
        )

        Spacer(modifier = Modifier.height(32.dp))

        OtpTextField(state = otpState)
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun VerifyOtpButtonSection(
    modifier: Modifier = Modifier,
    countdown: String,
    onVerifyOtpClick: () -> Unit,
    onResendOtpClick: () -> Unit,
) {
    Column(modifier = modifier) {
        Button(
            contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
            onClick = onVerifyOtpClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                stringResource(Res.string.button_verify_otp),
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onResendOtpClick,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
        ) {
            Text(
                text = stringResource(Res.string.button_resend_otp, countdown),
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}
