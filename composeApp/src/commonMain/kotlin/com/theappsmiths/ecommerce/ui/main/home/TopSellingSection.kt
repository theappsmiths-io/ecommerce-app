package com.theappsmiths.ecommerce.ui.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theappsmiths.designsystem.ui.header.HeaderWithNavigation
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.ui.productlist.ProductCard
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.header_navigation_label
import ecommerce.composeapp.generated.resources.header_top_selling
import org.jetbrains.compose.resources.stringResource

@Composable
fun TopSellingSection(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onProductClick: (productId: Int) -> Unit,
    onViewAllTopSelling: () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        HeaderWithNavigation(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = stringResource(Res.string.header_top_selling),
            navigationTitle = stringResource(Res.string.header_navigation_label),
            onNavigationClick = onViewAllTopSelling,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(products) { product ->
                ProductCard(
                    modifier = Modifier.width(156.dp),
                    product = product,
                    onProductClick = onProductClick,
                )
            }
        }
    }
}
