package com.theappsmiths.ecommerce.ui.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.theappsmiths.designsystem.ui.common.rememberThrottledClickHandler
import com.theappsmiths.designsystem.ui.item.ItemCard
import com.theappsmiths.designsystem.ui.loadingindicator.FullscreenLoadingIndicator
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.model.Rating
import com.theappsmiths.ecommerce.util.formatToUsd
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    onProductClick: (productId: Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    //This is added to prevent simultaneous clicks on product items
    val throttledClickHandler = rememberThrottledClickHandler<Int>(
        onClick = { productId ->
            onProductClick(productId)
        }
    )
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            ProductListAppBar(
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        if (uiState.isLoading) {
            FullscreenLoadingIndicator()
        } else {
            ProductListScreen(
                products = uiState.products,
                modifier = modifier.padding(innerPadding).padding(horizontal = 16.dp),
                onProductClick = { productId ->
                    throttledClickHandler(productId)
                },
            )
        }
    }
}

@Composable
fun ProductListScreen(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (productId: Int) -> Unit,
) {
    ProductGridList(
        products = products,
        modifier = modifier.fillMaxSize(),
        onProductClick = onProductClick,
    )
}

@Composable
fun ProductGridList(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (productId: Int) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            ProductCard(product = product, onProductClick = onProductClick)
        }
    }
}

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product,
    onProductClick: (productId: Int) -> Unit,
) {
    ItemCard(
        modifier = modifier,
        title = product.title,
        price = product.price.formatToUsd(),
        imageContent = {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Fit,
            )
        },
        onCardClick = { onProductClick(product.id) }
    )
}

@Preview
@Composable
fun ProductCardPreview() {
    MaterialTheme {
        ProductCard(
            product = Product(
                id = 1,
                title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                price = 109.95,
                description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                category = "men's clothing",
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
                rating = Rating(
                    rate = 3.9,
                    count = 120
                )
            ),
            onProductClick = {},
        )
    }
}
