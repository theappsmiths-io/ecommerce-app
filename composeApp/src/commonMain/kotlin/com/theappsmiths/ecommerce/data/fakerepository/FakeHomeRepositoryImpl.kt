package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeCategories
import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeForYouProducts
import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeTopSellingProducts
import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.repository.HomeRepository

class FakeHomeRepositoryImpl : HomeRepository {
    override fun getCategories(): List<Category> {
        return fakeCategories
    }

    override fun getTopSellingProducts(): List<Product> {
        return fakeTopSellingProducts
    }

    override fun getForYouProducts(): List<Product> {
        return fakeForYouProducts
    }
}
