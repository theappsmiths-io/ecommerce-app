package com.theappsmiths.ecommerce.domain.repository

import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product

interface HomeRepository {
    fun getCategories(): List<Category>

    fun getTopSellingProducts(): List<Product>

    fun getForYouProducts(): List<Product>
}
