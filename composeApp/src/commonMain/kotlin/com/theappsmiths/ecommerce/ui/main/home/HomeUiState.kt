package com.theappsmiths.ecommerce.ui.main.home

import com.theappsmiths.ecommerce.domain.model.MainCategory
import com.theappsmiths.ecommerce.domain.model.Product
import org.jetbrains.compose.resources.DrawableResource

data class HomeUiState(
    val isLoading: Boolean = false,
    val banners: List<DrawableResource> = emptyList(),
    val categories: List<MainCategory> = emptyList(),
    val topSellingProducts: List<Product> = emptyList(),
    val forYouProducts: List<Product> = emptyList(),
)
