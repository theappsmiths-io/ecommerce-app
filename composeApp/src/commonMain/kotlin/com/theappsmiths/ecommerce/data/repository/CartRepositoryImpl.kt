package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeCartItems
import com.theappsmiths.ecommerce.domain.model.CartItem
import com.theappsmiths.ecommerce.domain.repository.CartRepository

class CartRepositoryImpl : CartRepository {
    override suspend fun getCartItems(): List<CartItem> {
        //TODO update this once API is ready
        return fakeCartItems
    }

    override suspend fun addToCart(cartItem: CartItem) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromCart(cartItem: CartItem) {
        TODO("Not yet implemented")
    }
}
