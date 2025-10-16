package com.theappsmiths.ecommerce.ui.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theappsmiths.designsystem.ui.common.rememberThrottledClickHandler
import com.theappsmiths.designsystem.ui.pager.BannerHorizontalPager
import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.ui.productlist.ProductCard
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.banner1
import ecommerce.composeapp.generated.resources.header_just_for_you
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoute(
    viewModel: HomeViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    onCategoryClick: (categoryId: Int) -> Unit,
    onProductClick: (productId: Int) -> Unit,
    onViewAllCategories: () -> Unit,
    onViewAllTopSelling: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val throttledClickHandler = rememberThrottledClickHandler<Int>(
        onClick = { productId ->
            onProductClick(productId)
        }
    )
    HomeScreen(
        modifier = modifier,
        categories = uiState.categories,
        topSellingProducts = uiState.topSellingProducts,
        forYouProducts = uiState.forYouProducts,
        onCategoryClick = onCategoryClick,
        onProductClick = { productId ->
            throttledClickHandler(productId)
        },
        onViewAllCategories = onViewAllCategories,
        onViewAllTopSelling = onViewAllTopSelling,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    topSellingProducts: List<Product>,
    forYouProducts: List<Product>,
    onCategoryClick: (categoryId: Int) -> Unit,onProductClick: (productId: Int) -> Unit,
    onViewAllCategories: () -> Unit,
    onViewAllTopSelling: () -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            val banners = listOf(
                Res.drawable.banner1,
                Res.drawable.banner1,
                Res.drawable.banner1,
            )
            BannerHorizontalPager(
                modifier = Modifier.padding(horizontal = 16.dp),
                banners = banners
            )
        }

        item {
            CategorySection(
                categories = categories,
                onCategoryClick = onCategoryClick,
                onViewAllCategories = onViewAllCategories,
            )
        }

         item {
             TopSellingSection(
                 products = topSellingProducts,
                 onProductClick = onProductClick,
                 onViewAllTopSelling = onViewAllTopSelling,
             )
        }

        item {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(Res.string.header_just_for_you),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = Bold,
            )
        }

        productGridItems(
            products = forYouProducts,
            onProductClick = onProductClick
        )
    }
}

fun LazyListScope.productGridItems(
    products: List<Product>,
    onProductClick: (productId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val productRows = products.chunked(2)

    items(
        items = productRows,
        key = { row -> row.joinToString { it.id.toString() } }
    ) { row ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            row.forEach { product ->
                ProductCard(
                    modifier = Modifier.weight(1f),
                    product = product,
                    onProductClick = { onProductClick(product.id) }
                )
            }

            if (row.size == 1) {
                Spacer(Modifier.weight(1f))
            }
        }
    }
}
