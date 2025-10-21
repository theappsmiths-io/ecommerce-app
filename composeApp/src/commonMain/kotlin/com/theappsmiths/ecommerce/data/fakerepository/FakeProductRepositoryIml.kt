package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeProductList
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.repository.ProductRepository
import kotlinx.coroutines.delay

class FakeProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return fakeProductList
    }

    override suspend fun getProductDetails(id: Int): Product {
        delay(500)
        return fakeProductList.first { it.id == id }
    }
}
