package com.theappsmiths.ecommerce.ui.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.header_signup
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignUpScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = stringResource(Res.string.header_signup))
    }
}
