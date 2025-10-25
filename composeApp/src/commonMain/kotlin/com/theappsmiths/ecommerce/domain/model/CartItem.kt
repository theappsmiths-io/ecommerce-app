package com.theappsmiths.ecommerce.domain.model

data class CartItem(
    val productId: Int,
    val name: String,
    val price: Double,
    val quantity: Int,
    val attributes: Map<String, String>? = null,
    val imageUrl: String,
    val isSelected: Boolean = true,
)
