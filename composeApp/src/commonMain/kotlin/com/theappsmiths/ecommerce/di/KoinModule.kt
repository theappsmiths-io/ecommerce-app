package com.theappsmiths.ecommerce.di

import com.theappsmiths.ecommerce.BuildKonfig
import com.theappsmiths.ecommerce.data.fakerepository.FakeCartRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeCategoryRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeHomeRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeOnboardingRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeOtpRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeProductRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.CartRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.CategoryRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.HomeRepositoryIml
import com.theappsmiths.ecommerce.data.repository.OnboardingRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.OtpRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.ProductRepositoryImpl
import com.theappsmiths.ecommerce.domain.repository.CartRepository
import com.theappsmiths.ecommerce.domain.repository.CategoryRepository
import com.theappsmiths.ecommerce.domain.repository.HomeRepository
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository
import com.theappsmiths.ecommerce.domain.repository.OtpRepository
import com.theappsmiths.ecommerce.domain.repository.ProductRepository
import com.theappsmiths.ecommerce.ui.emailverification.verifyotp.VerifyOtpViewModel
import com.theappsmiths.ecommerce.ui.login.LoginViewModel
import com.theappsmiths.ecommerce.ui.main.cart.CartViewModel
import com.theappsmiths.ecommerce.ui.main.category.CategoryViewModel
import com.theappsmiths.ecommerce.ui.main.home.HomeViewModel
import com.theappsmiths.ecommerce.ui.productdetails.ProductDetailsViewModel
import com.theappsmiths.ecommerce.ui.productlist.ProductListViewModel
import com.theappsmiths.ecommerce.ui.signup.SignUpViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun appModules() = listOf(productModule, dataModule)

val productModule = module {
    viewModel { LoginViewModel(onboardingRepository = get()) }

    viewModel { SignUpViewModel(onboardingRepository = get()) }

    viewModel { ProductListViewModel(productRepository = get()) }

    viewModel { VerifyOtpViewModel(otpRepository = get()) }

    viewModel { HomeViewModel(homeRepository = get()) }

    viewModel { (id: Int) ->
        ProductDetailsViewModel(productId = id, productRepository = get())
    }

    viewModel { (id: String?) ->
        CategoryViewModel(selectedCategoryId = id, categoryRepository = get())
    }

    viewModel { CartViewModel(cartRepository = get()) }
}

val fakeDataModule = module {
    factory<OnboardingRepository> { FakeOnboardingRepositoryImpl() }
    factory<ProductRepository> { FakeProductRepositoryImpl() }
    factory<OtpRepository> { FakeOtpRepositoryImpl() }
    factory<HomeRepository> { FakeHomeRepositoryImpl() }
    factory<CategoryRepository> { FakeCategoryRepositoryImpl() }
    factory<CartRepository> { FakeCartRepositoryImpl() }
}

val prodDataModule = module {
    factory<OnboardingRepository> { OnboardingRepositoryImpl() }
    factory<ProductRepository> { ProductRepositoryImpl() }
    factory<OtpRepository> { OtpRepositoryImpl() }
    factory<HomeRepository> { HomeRepositoryIml() }
    factory<CategoryRepository> { CategoryRepositoryImpl() }
    factory<CartRepository> { CartRepositoryImpl() }
}

val dataModule = when (BuildKonfig.ENV) {
    "fake" -> fakeDataModule
    else -> prodDataModule
}
