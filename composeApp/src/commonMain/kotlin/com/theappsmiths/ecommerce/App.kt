package com.theappsmiths.ecommerce

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.theappsmiths.ecommerce.navigation.Route
import com.theappsmiths.ecommerce.ui.productlist.ProductListScreen
import com.theappsmiths.ecommerce.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }
    AppTheme {
        ECommerceApp()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ECommerceApp() {
    val navController = rememberNavController()
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    NavHost(
        navController = navController,
        startDestination = Route.ProductList,
    ) {
        composable<Route.ProductList> {
            ProductListScreen(
                scrollBehavior = scrollBehavior,
                onProductClick = { id ->
                    //TODO navigate to Product Details screen
                }
            )
        }
    }
}
