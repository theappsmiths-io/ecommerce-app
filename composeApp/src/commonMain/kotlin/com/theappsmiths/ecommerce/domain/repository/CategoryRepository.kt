package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.MainCategory

interface CategoryRepository {
    suspend fun getCategories(): List<MainCategory>
}
