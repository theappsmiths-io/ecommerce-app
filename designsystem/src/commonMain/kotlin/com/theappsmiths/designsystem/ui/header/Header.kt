package com.theappsmiths.designsystem.ui.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

@Composable
fun HeaderWithNavigation(
    modifier: Modifier = Modifier,
    title: String,
    navigationTitle: String,
    onNavigationClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = Bold,
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = onNavigationClick,
        ) {
            Text(
                text = navigationTitle,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = Bold,
            )
        }
    }
}
