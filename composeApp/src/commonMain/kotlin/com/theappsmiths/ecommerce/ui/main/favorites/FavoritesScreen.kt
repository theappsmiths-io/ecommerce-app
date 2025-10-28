package com.theappsmiths.ecommerce.ui.main.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.theappsmiths.designsystem.ui.loadingindicator.FullscreenLoadingIndicator
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.ui.productlist.ProductGridList
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.title_favorites
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = koinViewModel(),
    navController: NavController,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val sheetState = rememberModalBottomSheetState()
    var showConfirmBottomSheet by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var selectedProductId: Int? by rememberSaveable { mutableStateOf(null) }

    Scaffold(
        topBar = {
            FavoriteAppBar(
                title = stringResource(Res.string.title_favorites, uiState.favorites.size),
                canNavigateBack = navController.previousBackStackEntry != null,
                onNavigateUp = { navController.navigateUp() },
            )
        }
    ) { contentPadding ->
        if (uiState.isLoading) {
            FullscreenLoadingIndicator()
        } else {
            FavoriteScreen(
                modifier = modifier.padding(top = contentPadding.calculateTopPadding()).padding(horizontal = 16.dp),
                favorites = uiState.favorites,
                onFavoriteClick = { productId ->
                    selectedProductId = productId
                    showConfirmBottomSheet = true
                }
            )
        }

        if (showConfirmBottomSheet && selectedProductId != null) {
            FavoritesBottomSheet(
                product = viewModel.getProductById(selectedProductId!!)!!,
                sheetState = sheetState,
                onDismissRequest = {
                    showConfirmBottomSheet = false
                },
                onAddToCart = {
                    //TODO call add to cart
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showConfirmBottomSheet = false
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun FavoriteScreen(
    favorites: List<Product>,
    modifier: Modifier = Modifier,
    onFavoriteClick: (productId: Int) -> Unit,
) {
    ProductGridList(
        products = favorites,
        modifier = modifier.fillMaxSize(),
        onProductClick = onFavoriteClick,
    )
}
