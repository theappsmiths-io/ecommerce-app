package com.theappsmiths.ecommerce.ui.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theappsmiths.designsystem.ui.common.rememberThrottledClickHandler
import com.theappsmiths.designsystem.ui.pager.BannerHorizontalPager
import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.ui.main.category.CategorySection
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.banner1
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
    onCategoryClick: (categoryId: Int) -> Unit,
    onProductClick: (productId: Int) -> Unit,
    onViewAllCategories: () -> Unit,
    onViewAllTopSelling: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        val banners = listOf(
            Res.drawable.banner1,
            Res.drawable.banner1,
            Res.drawable.banner1,
        )
        BannerHorizontalPager(modifier = Modifier.padding(horizontal = 16.dp), banners = banners)

        Spacer(modifier = Modifier.padding(16.dp))

        CategorySection(
            categories = categories,
            onCategoryClick = onCategoryClick,
            onViewAllCategories = onViewAllCategories,
        )

        Spacer(modifier = Modifier.padding(16.dp))

        TopSellingSection(
            products = topSellingProducts,
            onProductClick = onProductClick,
            onViewAllTopSelling = onViewAllTopSelling,
        )
    }
}
