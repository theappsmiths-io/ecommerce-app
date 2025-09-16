package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.model.Rating
import com.theappsmiths.ecommerce.domain.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        //TODO update this once API is ready
        return emptyList()
    }

    override suspend fun getProductDetails(id: Int): Product {
        //TODO update this once API is ready
        return Product(
            id = 2,
            title = "Slim Fit Denim Jeans",
            price = 49.95,
            description = "Modern slim fit jeans crafted from high-quality denim with a slight stretch for comfort.",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg", // Example image
            rating = Rating(rate = 4.1, count = 259)
        )
    }
}
