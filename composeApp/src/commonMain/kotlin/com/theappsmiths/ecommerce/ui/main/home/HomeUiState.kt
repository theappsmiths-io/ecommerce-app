package com.theappsmiths.ecommerce.ui.main.home

import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product
import org.jetbrains.compose.resources.DrawableResource

data class HomeUiState(
    val isLoading: Boolean = false,
    val banners: List<DrawableResource> = emptyList(),
    val categories: List<Category> = emptyList(),
    val topSellingProducts: List<Product> = emptyList(),
)
