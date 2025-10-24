package com.theappsmiths.ecommerce.ui.main.category

import com.theappsmiths.ecommerce.domain.model.MainCategory

data class CategoryUiState(
    val isLoading: Boolean = false,
    val categories: List<MainCategory> = emptyList(),
    val selectedCategoryId: String? = null,
)
