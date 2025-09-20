package com.theappsmiths.designsystem.ui.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ecommerce.designsystem.generated.resources.Res
import ecommerce.designsystem.generated.resources.login_apple
import ecommerce.designsystem.generated.resources.login_google
import ecommerce.designsystem.generated.resources.logo_apple
import ecommerce.designsystem.generated.resources.logo_google
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val mediumSize = ButtonDefaults.MediumContainerHeight

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LogoButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    logoResourceId: DrawableResource,
    buttonText: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
        enabled = isEnabled,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(logoResourceId),
                contentDescription = buttonText,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = buttonText,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

@Composable
fun GoogleLoginButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    LogoButton(
        modifier = modifier,
        isEnabled = isEnabled,
        logoResourceId = Res.drawable.logo_google,
        buttonText = stringResource(Res.string.login_google),
        onClick = onClick,
    )
}

@Composable
fun AppleLoginButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    LogoButton(
        modifier = modifier,
        isEnabled = isEnabled,
        logoResourceId = Res.drawable.logo_apple,
        buttonText = stringResource(Res.string.login_apple),
        onClick = onClick,
    )
}
