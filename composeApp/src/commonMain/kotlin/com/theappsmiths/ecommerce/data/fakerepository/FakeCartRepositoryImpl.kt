package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeCartItems
import com.theappsmiths.ecommerce.domain.model.CartItem
import com.theappsmiths.ecommerce.domain.repository.CartRepository
import kotlinx.coroutines.delay

class FakeCartRepositoryImpl : CartRepository {
    override suspend fun getCartItems(): List<CartItem> {
        delay(700)
        return fakeCartItems
    }

    override suspend fun addToCart(cartItem: CartItem) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromCart(cartItem: CartItem) {
        TODO("Not yet implemented")
    }
}
