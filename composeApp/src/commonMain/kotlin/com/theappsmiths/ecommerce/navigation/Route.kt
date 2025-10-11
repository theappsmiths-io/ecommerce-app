package com.theappsmiths.ecommerce.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route {
    //Onboarding screens
    @Serializable
    data object Login : Route()

    @Serializable
    data object SignUp : Route()

    @Serializable
    data object VerifyOtp : Route()

    //Main screens
    @Serializable
    data object MainContainer : Route()

    @Serializable
    data object Home : Route()

    @Serializable
    data object Category : Route()

    @Serializable
    data object Cart : Route()

    @Serializable
    data object Favorite : Route()

    @Serializable
    data object Profile : Route()

    @Serializable
    data class ProductList(val productListType: String) : Route()

    @Serializable
    data class ProductDetails(val id: Int): Route()
}
