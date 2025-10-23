package com.theappsmiths.ecommerce.data.repository

import com.theappsmiths.ecommerce.data.fakerepository.FakeData
import com.theappsmiths.ecommerce.domain.model.MainCategory
import com.theappsmiths.ecommerce.domain.repository.CategoryRepository
import kotlinx.coroutines.delay

class CategoryRepositoryImpl : CategoryRepository {
    override suspend fun getCategories(): List<MainCategory> {
        //TODO update this once API is ready
        delay(1000)
        return FakeData.fakeCategories
    }
}
