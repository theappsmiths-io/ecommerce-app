package com.theappsmiths.ecommerce.ui.main.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoryViewModel(
    selectedCategoryId: String?,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoryUiState())
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    init {
        getCategories(selectedCategoryId)
    }

    private fun getCategories(selectedCategory: String?) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val categories = categoryRepository.getCategories()
            _uiState.update {
                it.copy(
                    categories = categories,
                    isLoading = false,
                    selectedCategoryId = selectedCategory,
                )
            }
        }
    }

    fun onCategorySelected(categoryId: String?) {
        _uiState.update { it.copy(selectedCategoryId = categoryId) }
    }
}
