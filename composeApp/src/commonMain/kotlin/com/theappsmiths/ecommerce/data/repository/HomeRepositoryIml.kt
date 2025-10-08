package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeCategories
import com.theappsmiths.ecommerce.data.fakerepository.FakeData.fakeProductList
import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.repository.HomeRepository

class HomeRepositoryIml : HomeRepository {
    override fun getCategories(): List<Category> {
        //TODO update this once API is ready
        return fakeCategories
    }

    override fun getTopSellingProducts(): List<Product> {
        //TODO update this once API is ready
        return  fakeProductList
    }
}
