package com.theappsmiths.ecommerce.ui.main.cart

import com.theappsmiths.ecommerce.domain.model.CartItem

data class CartUiState(
    val isLoading: Boolean = false,
    val cartItems: List<CartItem> = emptyList(),
)
