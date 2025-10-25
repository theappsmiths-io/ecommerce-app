package com.theappsmiths.ecommerce.ui.main.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappsmiths.ecommerce.domain.repository.CartRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState())
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    init {
        getCartItems()
    }

    private fun getCartItems() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val cartItems = cartRepository.getCartItems()
            _uiState.update {
                it.copy(cartItems = cartItems, isLoading = false)
            }
        }
    }
}
