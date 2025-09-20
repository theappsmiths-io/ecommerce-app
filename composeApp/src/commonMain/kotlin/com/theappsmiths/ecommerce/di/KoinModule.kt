package com.theappsmiths.ecommerce.di

import com.theappsmiths.ecommerce.BuildKonfig
import com.theappsmiths.ecommerce.data.fakerepository.FakeLoginRepositoryImpl
import com.theappsmiths.ecommerce.data.fakerepository.FakeProductRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.LoginRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.ProductRepositoryImpl
import com.theappsmiths.ecommerce.domain.repository.LoginRepository
import com.theappsmiths.ecommerce.domain.repository.ProductRepository
import com.theappsmiths.ecommerce.ui.login.LoginViewModel
import com.theappsmiths.ecommerce.ui.productdetails.ProductDetailsViewModel
import com.theappsmiths.ecommerce.ui.productlist.ProductListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun appModules() = listOf(productModule, dataModule)

val productModule = module {
    viewModel { LoginViewModel(loginRepository = get()) }

    viewModel { ProductListViewModel(productRepository = get()) }

    viewModel { (id: Int) ->
        ProductDetailsViewModel(productId = id, productRepository = get())
    }
}

val fakeDataModule = module {
    factory<LoginRepository> { FakeLoginRepositoryImpl() }
    factory<ProductRepository> { FakeProductRepositoryImpl() }
}

val prodDataModule = module {
    factory<LoginRepository> { LoginRepositoryImpl() }
    factory<ProductRepository> { ProductRepositoryImpl() }
}

val dataModule = when (BuildKonfig.ENV) {
    "fake" -> fakeDataModule
    else -> prodDataModule
}
