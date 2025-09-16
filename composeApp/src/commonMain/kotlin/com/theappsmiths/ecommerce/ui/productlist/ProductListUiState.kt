package com.theappsmiths.ecommerce.ui.productlist

import com.theappsmiths.ecommerce.domain.model.Product

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
)
