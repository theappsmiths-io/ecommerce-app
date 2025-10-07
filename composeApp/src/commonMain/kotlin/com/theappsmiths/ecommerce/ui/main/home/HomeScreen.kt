package com.theappsmiths.ecommerce.ui.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theappsmiths.designsystem.ui.pager.BannerHorizontalPager
import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.ui.main.category.CategorySection
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.banner1

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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

        val categories = listOf(
            Category(1, "Household & Cleaning", "https://picsum.photos/id/237/200/200"),
            Category(2, "Health & Wellness", "https://picsum.photos/id/123/200/200"),
            Category(3, "Fashion & Apparel", "https://picsum.photos/id/21/200/200"),
            Category(4, "Jewelry & Collections", "https://picsum.photos/id/219/200/200"),
            Category(5, "Bags & Accessories", "https://picsum.photos/id/3/200/200"),
            Category(6, "Furniture & Home", "https://picsum.photos/id/65/200/200"),
        )

        CategorySection(
            categories = categories,
            onCategoryClick = {},
            onNavigationClick = {},
        )
    }
}
