package com.theappsmiths.ecommerce.di

import com.theappsmiths.ecommerce.BuildKonfig
import com.theappsmiths.ecommerce.data.fakerepository.FakeOnboardingRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeOtpRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeProductRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.OnboardingRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.OtpRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.ProductRepositoryImpl
import com.theappsmiths.ecommerce.domain.repository.OnboardingRepository
import com.theappsmiths.ecommerce.domain.repository.OtpRepository
import com.theappsmiths.ecommerce.domain.repository.ProductRepository
import com.theappsmiths.ecommerce.ui.emailverification.verifyotp.VerifyOtpViewModel
import com.theappsmiths.ecommerce.ui.login.LoginViewModel
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

    viewModel { (id: Int) ->
        ProductDetailsViewModel(productId = id, productRepository = get())
    }
}

val fakeDataModule = module {
    factory<OnboardingRepository> { FakeOnboardingRepositoryImpl() }
    factory<ProductRepository> { FakeProductRepositoryImpl() }
    factory<OtpRepository> { FakeOtpRepositoryImpl() }
}

val prodDataModule = module {
    factory<OnboardingRepository> { OnboardingRepositoryImpl() }
    factory<ProductRepository> { ProductRepositoryImpl() }
    factory<OtpRepository> { OtpRepositoryImpl() }
}

val dataModule = when (BuildKonfig.ENV) {
    "fake" -> fakeDataModule
    else -> prodDataModule
}
