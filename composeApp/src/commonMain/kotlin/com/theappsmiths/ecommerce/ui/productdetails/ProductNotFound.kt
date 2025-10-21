package com.theappsmiths.ecommerce.ui.productdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.product_not_found
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProductNotFound() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = stringResource(Res.string.product_not_found))
    }
}
