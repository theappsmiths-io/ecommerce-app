package com.theappsmiths.ecommerce.ui.productdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.add_to_cart
import ecommerce.composeapp.generated.resources.buy_now
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ProductDetailsBottomBar(
    modifier: Modifier = Modifier,
    onAddToCartClick: () -> Unit,
    onBuyNowClick: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shadowElevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .navigationBarsPadding()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onAddToCartClick,
                modifier = Modifier.weight(1f),
                shape = ButtonDefaults.squareShape,
                contentPadding = ButtonDefaults.contentPaddingFor(ButtonDefaults.MediumContainerHeight),
            ) {
                Text(stringResource(Res.string.add_to_cart))
            }

            Button(
                onClick = onBuyNowClick,
                modifier = Modifier.weight(1f),
                shape = ButtonDefaults.squareShape,
                contentPadding = ButtonDefaults.contentPaddingFor(ButtonDefaults.MediumContainerHeight),
            ) {
                Text(stringResource(Res.string.buy_now))
            }
        }
    }
}
