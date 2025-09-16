package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>

    suspend fun getProductDetails(id: Int): Product
}
