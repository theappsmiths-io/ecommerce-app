package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.Product

interface FavoritesRepository {

    suspend fun getFavorites(): List<Product>

    suspend fun addToFavorites()

    suspend fun removeFromFavorites()
}
