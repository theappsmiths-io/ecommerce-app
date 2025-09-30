package com.theappsmiths.designsystem.ui.button

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoadingButton(
    isLoading: Boolean,
    areInputsValid: Boolean,
    buttonLabel: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = isLoading,
            transitionSpec = { (fadeIn() togetherWith fadeOut()) },
            label = buttonLabel,
        ) { targetIsLoading ->
            if (targetIsLoading) {
                LoadingIndicator(modifier = Modifier.size(48.dp))
            } else {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = areInputsValid,
                    contentPadding = ButtonDefaults.contentPaddingFor(mediumSize),
                    onClick = onClick,
                ) {
                    Text(
                        text = buttonLabel,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
        }
    }
}
