package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeFavorites
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.repository.FavoritesRepository

class FavoritesRepositoryImpl : FavoritesRepository {
    override suspend fun getFavorites(): List<Product> {
        //TODO update this once API is ready
        return fakeFavorites
    }

    override suspend fun addToFavorites() {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites() {
        TODO("Not yet implemented")
    }
}
