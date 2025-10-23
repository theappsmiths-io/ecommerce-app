package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.domain.model.MainCategory
import com.theappsmiths.ecommerce.domain.repository.CategoryRepository
import kotlinx.coroutines.delay

class FakeCategoryRepositoryImpl : CategoryRepository {
    override suspend fun getCategories(): List<MainCategory> {
        delay(1000)
        return FakeData.fakeCategories
    }
}
