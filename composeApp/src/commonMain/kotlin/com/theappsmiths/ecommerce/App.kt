package com.theappsmiths.ecommerce

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.theappsmiths.designsystem.ui.theme.AppTheme
import com.theappsmiths.ecommerce.navigation.Route
import com.theappsmiths.ecommerce.ui.emailverification.verifyotp.VerifyOtpScreen
import com.theappsmiths.ecommerce.ui.login.LoginScreen
import com.theappsmiths.ecommerce.ui.main.MainContainerScreen
import com.theappsmiths.ecommerce.ui.signup.SignUpScreen
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

    NavHost(
        navController = navController,
        startDestination = Route.Login,
    ) {
        composable<Route.Login> {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Route.MainContainer) {
                        popUpTo<Route.Login> {
                            inclusive = true
                        }
                    }
                },
                onSignUpClick = { navController.navigate(Route.SignUp) })
        }

        composable<Route.SignUp> {
            SignUpScreen(
                onSignUpSuccess = {},
                onNavigateToLogin = {
                    navController.navigate(Route.Login) {
                        popUpTo<Route.SignUp> {
                            inclusive = true
                        }
                    }
                },
            )
        }
        composable<Route.VerifyOtp> {
            VerifyOtpScreen(navController = navController)
        }

        composable<Route.MainContainer> {
            MainContainerScreen()
        }
    }
}
