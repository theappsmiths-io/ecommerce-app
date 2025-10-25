package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.CartItem

interface CartRepository {

    suspend fun getCartItems(): List<CartItem>

    suspend fun addToCart(cartItem: CartItem)

    suspend fun removeFromCart(cartItem: CartItem)
}
