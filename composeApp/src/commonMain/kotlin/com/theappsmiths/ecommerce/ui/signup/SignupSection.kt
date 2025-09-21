package com.theappsmiths.ecommerce.ui.signup

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import com.theappsmiths.designsystem.ui.button.AppleButton
import com.theappsmiths.designsystem.ui.button.GoogleButton
import com.theappsmiths.designsystem.ui.button.HighlightTextButton
import com.theappsmiths.designsystem.ui.button.mediumSize
import com.theappsmiths.designsystem.ui.divider.TextDivider
import com.theappsmiths.designsystem.ui.field.EmailTextField
import com.theappsmiths.designsystem.ui.field.InputFieldState
import com.theappsmiths.designsystem.ui.field.PasswordTextField
import com.theappsmiths.designsystem.ui.field.emailStateValidator
import com.theappsmiths.designsystem.ui.field.passwordStateValidator
import com.theappsmiths.designsystem.ui.theme.AppTheme
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.button_signup
import ecommerce.composeapp.generated.resources.header_signup
import ecommerce.composeapp.generated.resources.label_login_divider
import ecommerce.composeapp.generated.resources.redirect_login_highlight
import ecommerce.composeapp.generated.resources.redirect_login_text
import ecommerce.composeapp.generated.resources.sign_up_privacy_policy
import ecommerce.composeapp.generated.resources.sign_up_terms_intro
import ecommerce.composeapp.generated.resources.sign_up_terms_of_use
import ecommerce.composeapp.generated.resources.sign_up_terms_separator
import ecommerce.composeapp.generated.resources.signup_apple
import ecommerce.composeapp.generated.resources.signup_google
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SignUpSection(
    modifier: Modifier = Modifier,
    emailInputFieldState: InputFieldState,
    passwordInputFieldState: InputFieldState,
    onSignUpClick: (email: String, password: String) -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    val areInputsValid = emailInputFieldState.isValid() && passwordInputFieldState.isValid()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.header_signup),
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
                onSignUpClick(
                    emailInputFieldState.textFieldState.text.toString(),
                    passwordInputFieldState.textFieldState.text.toString(),
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            enabled = areInputsValid,
            contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
            onClick = {
                onSignUpClick(
                    emailInputFieldState.textFieldState.text.toString(),
                    passwordInputFieldState.textFieldState.text.toString(),
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                stringResource(Res.string.button_signup),
                style = MaterialTheme.typography.labelLarge,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextDivider(text = stringResource(Res.string.label_login_divider))

        Spacer(modifier = Modifier.height(16.dp))

        GoogleButton(buttonText = stringResource(Res.string.signup_google)) { }

        Spacer(modifier = Modifier.height(8.dp))

        AppleButton(buttonText = stringResource(Res.string.signup_apple)) { }

        Spacer(modifier = Modifier.height(24.dp))

        HighlightTextButton(
            text = stringResource(Res.string.redirect_login_text),
            textToHighlight = stringResource(Res.string.redirect_login_highlight),
            onClick = onNavigateToLogin,
        )

        Spacer(modifier = Modifier.height(32.dp))

        TermsAndPrivacyClickableLink()
    }
}

@Composable
fun TermsAndPrivacyClickableLink(highlightColor: Color = MaterialTheme.colorScheme.primary) {
    //TODO update URLs once valid URLs are available
    Text(
        text = buildAnnotatedString {
            append(stringResource(Res.string.sign_up_terms_intro))
            withLink(
                LinkAnnotation.Url(
                    "https://developer.android.com/jetpack/compose",
                    TextLinkStyles(
                        style = SpanStyle(color = highlightColor)
                    )
                )
            ) {
                append(stringResource(Res.string.sign_up_terms_of_use))
            }
            append(stringResource(Res.string.sign_up_terms_separator))
            withLink(
                LinkAnnotation.Url(
                    "https://developer.android.com/jetpack/compose",
                    TextLinkStyles(
                        style = SpanStyle(color = highlightColor)
                    )
                )
            ) {
                append(stringResource(Res.string.sign_up_privacy_policy))
            }
            append(".")
        },
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
fun LoginSectionPreview() {
    AppTheme {
        Surface {
            SignUpSection(
                emailInputFieldState = InputFieldState(validator = emailStateValidator),
                passwordInputFieldState = InputFieldState(validator = passwordStateValidator),
                onSignUpClick = { _, _ -> },
                onNavigateToLogin = {}
            )
        }
    }
}
