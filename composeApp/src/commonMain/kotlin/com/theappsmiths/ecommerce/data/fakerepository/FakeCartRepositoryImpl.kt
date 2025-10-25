package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeCartItems
import com.theappsmiths.ecommerce.domain.model.CartItem
import com.theappsmiths.ecommerce.domain.repository.CartRepository

class FakeCartRepositoryImpl : CartRepository {
    override suspend fun getCartItems(): List<CartItem> {
        return fakeCartItems
    }

    override suspend fun addToCart(cartItem: CartItem) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromCart(cartItem: CartItem) {
        TODO("Not yet implemented")
    }
}
