package com.theappsmiths.designsystem.ui.button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun HighlightTextButton(
    text: String,
    textToHighlight: String,
    modifier: Modifier = Modifier,
    highlightColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit,
) {
    TextButton(
        colors = ButtonDefaults.textButtonColors().copy(contentColor = MaterialTheme.colorScheme.onSurface),
        onClick = onClick,
        modifier = modifier
    ) {
        val annotatedString = buildAnnotatedString {
            val startIndex = text.indexOf(textToHighlight, ignoreCase = true)
            if (startIndex != -1) {
                append(text.substring(0, startIndex))

                withStyle(style = SpanStyle(color = highlightColor, fontWeight = FontWeight.Bold)) {
                    append(text.substring(startIndex, startIndex + textToHighlight.length))
                }

                append(text.substring(startIndex + textToHighlight.length, text.length))
            } else {
                append(text)
            }
        }
        Text(text = annotatedString, style = MaterialTheme.typography.bodySmall)
    }
}
