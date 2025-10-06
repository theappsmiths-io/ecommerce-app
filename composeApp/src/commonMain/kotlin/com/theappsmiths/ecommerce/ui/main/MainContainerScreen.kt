package com.theappsmiths.ecommerce.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.theappsmiths.ecommerce.navigation.Route
import com.theappsmiths.ecommerce.navigation.TopLevelRoute
import com.theappsmiths.ecommerce.ui.main.cart.CartScreen
import com.theappsmiths.ecommerce.ui.main.category.CategoryScreen
import com.theappsmiths.ecommerce.ui.main.favorite.FavoriteScreen
import com.theappsmiths.ecommerce.ui.main.home.HomeScreen
import com.theappsmiths.ecommerce.ui.main.profile.ProfileScreen

@Composable
fun MainContainerScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                TopLevelRoute.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.hasRoute(destination.route::class) } == true,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.label,
                            )
                        },
                        label = {
                            Text(
                                text = destination.label,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                    )
                }
            }
        }
    ) { contentPadding ->
        NavHost(
            modifier = Modifier.padding(contentPadding),
            navController = navController,
            startDestination = Route.Home,
        ) {
            composable<Route.Home> {
                HomeScreen()
            }
            composable<Route.Category> {
                CategoryScreen()
            }
            composable<Route.Cart> {
                CartScreen()
            }
            composable<Route.Favorite> {
                FavoriteScreen()
            }
            composable<Route.Profile> {
                ProfileScreen()
            }
        }
    }
}
