package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.MainCategory
import com.theappsmiths.ecommerce.domain.model.Product

interface HomeRepository {
    fun getCategories(): List<MainCategory>

    fun getTopSellingProducts(): List<Product>

    fun getForYouProducts(): List<Product>
}
