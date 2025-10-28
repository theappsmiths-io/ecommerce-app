package com.theappsmiths.ecommerce.ui.main.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(val favoritesRepository: FavoritesRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val favorites = favoritesRepository.getFavorites()
            _uiState.update {
                it.copy(
                    isLoading = false,
                    favorites = favorites,
                )
            }
        }
    }

    fun getProductById(productId: Int): Product? {
        return _uiState.value.favorites.find { it.id == productId }
    }
}
