package com.theappsmiths.ecommerce.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelRoute(
    val route: Route,
    val label: String,
    val icon: ImageVector,
) {
    HOME(route = Route.Home, label = "Home", icon = Icons.Default.Home),
    CATEGORY(route = Route.Category(), label = "Category", icon = Icons.Default.Category),
    CART(route = Route.Cart, label = "Cart", icon = Icons.Default.ShoppingCart),
    FAVORITE(route = Route.Favorite, label = "Favorite", icon = Icons.Default.Favorite),
    PROFILE(route = Route.Profile, label = "Me", icon = Icons.Default.Person)
}
