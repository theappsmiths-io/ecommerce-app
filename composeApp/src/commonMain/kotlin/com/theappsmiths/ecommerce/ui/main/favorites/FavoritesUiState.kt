package com.theappsmiths.ecommerce.ui.main.favorites

import com.theappsmiths.ecommerce.domain.model.Product

data class FavoritesUiState(
    val isLoading: Boolean = false,
    val favorites: List<Product> = emptyList(),
)
