package com.theappsmiths.designsystem.ui.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import ecommerce.designsystem.generated.resources.Res
import ecommerce.designsystem.generated.resources.button_dialog_okay
import org.jetbrains.compose.resources.stringResource

@Composable
fun SimpleAlertDialog(
    title: String,
    text: String,
    onDismiss: () -> Unit,
    confirmButtonLabel: String = stringResource(Res.string.button_dialog_okay)
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = title)
        },
        text = {
            Text(text = text)
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(text = confirmButtonLabel)
            }
        }
    )
}
