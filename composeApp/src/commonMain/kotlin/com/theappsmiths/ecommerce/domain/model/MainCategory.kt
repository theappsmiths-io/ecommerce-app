package com.theappsmiths.ecommerce.domain.model

interface Category {
    val id: String
    val name: String
}

data class MainCategory(
    override val id: String,
    override val name: String,
    val imageUrl: String,
    val subCategories: List<SubCategory>? = null,
) : Category

data class SubCategory(
    override val id: String,
    override val name: String,
    val mainCategoryId: String,
) : Category
