@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.theappsmiths.ecommerce.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.theappsmiths.designsystem.ui.searchbar.SearchBarInputField
import com.theappsmiths.ecommerce.navigation.Route
import com.theappsmiths.ecommerce.navigation.TopLevelRoute
import com.theappsmiths.ecommerce.ui.main.cart.CartScreen
import com.theappsmiths.ecommerce.ui.main.category.CategoryScreen
import com.theappsmiths.ecommerce.ui.main.category.CategoryViewModel
import com.theappsmiths.ecommerce.ui.main.favorite.FavoriteScreen
import com.theappsmiths.ecommerce.ui.main.home.HomeScreenRoute
import com.theappsmiths.ecommerce.ui.main.profile.ProfileScreen
import com.theappsmiths.ecommerce.ui.productdetails.ProductDetailsScreen
import com.theappsmiths.ecommerce.ui.productdetails.ProductDetailsViewModel
import com.theappsmiths.ecommerce.ui.productlist.ProductListScreen
import com.theappsmiths.ecommerce.ui.productlist.ProductListType
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

val LocalAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContainerScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val searchBarState = rememberSearchBarState()
    val textFieldState = rememberTextFieldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier,
        topBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination?.toTopLevelRoute()

            AnimatedVisibility(
                visible = currentDestination?.showAppBar == true,
                enter = fadeIn() + slideInVertically(initialOffsetY = { -it }),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { -it }),
            ) {
                SearchBar(
                    modifier = Modifier.padding(16.dp)
                        .windowInsetsPadding(TopAppBarDefaults.windowInsets),
                    state = searchBarState,
                    inputField = {
                        SearchBarInputField(
                            textFieldState = textFieldState,
                            searchBarState = searchBarState,
                            scope = scope,
                            onSearch = {},
                        )
                    }
                )
            }
        },
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            AnimatedVisibility(
                visible = isTopLevelScreen(currentDestination),
                enter = fadeIn() + slideInVertically(initialOffsetY = { +it }),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { +it }),
            ) {
                MainNavigationBar(
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        }
    ) { contentPadding ->
        //content padding is being applied differently for each screen due to different screen requirements
        SharedTransitionLayout {
            CompositionLocalProvider(LocalSharedTransitionScope provides this) {
                NavHost(
                    navController = navController,
                    startDestination = Route.Home,
                ) {
                    composable<Route.Home> {
                        CompositionLocalProvider(LocalAnimatedVisibilityScope provides this) {
                            HomeScreenRoute(
                                modifier = Modifier.padding(contentPadding),
                                onCategoryClick = { categoryId ->
                                    navController.navigateToTopLevel(Route.Category(selectedCategory = categoryId))
                                },
                                onProductClick = { id ->
                                    navController.navigate(Route.ProductDetails(id))
                                },
                                onViewAllCategories = {
                                    navController.navigateToTopLevel(Route.Category(selectedCategory = null))
                                },
                                onViewAllTopSelling = {
                                    navController.navigate(Route.ProductList(ProductListType.TOP_SELLING.toString()))
                                },
                            )
                        }
                    }
                    composable<Route.Category> { backStackEntry ->
                        val categoryId = backStackEntry.toRoute<Route.Category>().selectedCategory
                        val categoryViewModel: CategoryViewModel = koinViewModel {
                            parametersOf(categoryId)
                        }
                        CategoryScreen(
                            modifier = Modifier.padding(contentPadding),
                            viewModel = categoryViewModel,
                            onSubCategoryClick = {
                                //TODO navigate to filtered product list based on selected category
                                navController.navigate(Route.ProductList(ProductListType.ALL.toString()))
                            }
                        )
                    }
                    composable<Route.Cart> {
                        CartScreen(
                            modifier = Modifier.padding(bottom = contentPadding.calculateBottomPadding()),
                            navController = navController,
                        )
                    }
                    composable<Route.Favorite> {
                        FavoriteScreen(modifier = Modifier.padding(contentPadding))
                    }
                    composable<Route.Profile> {
                        ProfileScreen(modifier = Modifier.padding(contentPadding))
                    }
                    composable<Route.ProductList> { backStackEntry ->
                        val productListRoute = backStackEntry.toRoute<Route.ProductList>()
                        val productListType =
                            ProductListType.valueOf(productListRoute.productListType)

                        CompositionLocalProvider(LocalAnimatedVisibilityScope provides this) {
                            ProductListScreen(
                                navController = navController,
                                productListType = productListType,
                                onProductClick = { id ->
                                    navController.navigate(Route.ProductDetails(id))
                                }
                            )
                        }
                    }
                    composable<Route.ProductDetails> { backStackEntry ->
                        val productId = backStackEntry.toRoute<Route.ProductDetails>().id
                        val productDetailsViewModel: ProductDetailsViewModel = koinViewModel {
                            parametersOf(productId)
                        }
                        CompositionLocalProvider(LocalAnimatedVisibilityScope provides this) {
                            ProductDetailsScreen(
                                productId = productId,
                                viewModel = productDetailsViewModel,
                                navController = navController,
                                onCartClick = { navController.navigate(Route.Cart) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainNavigationBar(navController: NavHostController, currentDestination: NavDestination?) {
    NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
        TopLevelRoute.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(destination.route::class) } == true,
                onClick = {
                    navController.navigateToTopLevel(destination.route)
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
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

private fun isTopLevelScreen(currentDestination: NavDestination?): Boolean {
    val topLevelRoutes = TopLevelRoute.entries.map { it.route::class }
    return currentDestination != null && topLevelRoutes.any { currentDestination.hasRoute(it) }
}

private fun NavDestination.toTopLevelRoute(): TopLevelRoute? {
    return TopLevelRoute.entries.find { topLevelRoute ->
        this.hierarchy.any { it.hasRoute(topLevelRoute.route::class) }
    }
}

fun NavHostController.navigateToTopLevel(route: Route) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
