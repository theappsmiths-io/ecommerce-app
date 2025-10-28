package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeFavorites
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.repository.FavoritesRepository
import kotlinx.coroutines.delay

class FakeFavoritesRepositoryImpl : FavoritesRepository {
    override suspend fun getFavorites(): List<Product> {
        delay(500)
        return fakeFavorites
    }

    override suspend fun addToFavorites() {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites() {
        TODO("Not yet implemented")
    }
}
