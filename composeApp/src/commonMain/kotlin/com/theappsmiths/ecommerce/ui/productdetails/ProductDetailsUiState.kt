package com.theappsmiths.ecommerce.ui.productdetails

import com.theappsmiths.ecommerce.domain.model.Product

data class ProductDetailsUiState(
    val isLoading: Boolean = false,
    val product: Product? = null,
)
