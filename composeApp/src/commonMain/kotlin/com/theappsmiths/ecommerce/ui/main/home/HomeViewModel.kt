package com.theappsmiths.ecommerce.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(val homeRepository: HomeRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getCategories()
        getTopSellingProducts()
        getForYouProducts()
    }

    fun getCategories() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val categories = homeRepository.getCategories()
            _uiState.update { it.copy(categories = categories, isLoading = false) }
        }
    }

    fun getTopSellingProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val products = homeRepository.getTopSellingProducts()
            _uiState.update { it.copy(topSellingProducts = products, isLoading = false) }
        }
    }

    fun getForYouProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val products = homeRepository.getForYouProducts()
            _uiState.update { it.copy(forYouProducts = products, isLoading = false) }
        }
    }
}
