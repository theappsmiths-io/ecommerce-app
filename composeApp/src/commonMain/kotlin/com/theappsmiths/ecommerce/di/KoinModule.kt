package com.theappsmiths.ecommerce.di

import com.theappsmiths.ecommerce.BuildKonfig
import com.theappsmiths.ecommerce.data.fakerepository.FakeProductRepositoryImpl
import com.theappsmiths.ecommerce.data.repository.ProductRepositoryImpl
import com.theappsmiths.ecommerce.domain.repository.ProductRepository
import com.theappsmiths.ecommerce.ui.productdetails.ProductDetailsViewModel
import com.theappsmiths.ecommerce.ui.productlist.ProductListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun appModules() = listOf(productModule)

val productModule = module {
    factory<ProductRepository> {
        when (BuildKonfig.ENV) {
            "fake" -> FakeProductRepositoryImpl()
            else -> ProductRepositoryImpl()
        }


    }
    viewModel { ProductListViewModel(productRepository = get()) }

    viewModel { (id: Int) ->
        ProductDetailsViewModel(productId = id, productRepository = get())
    }
}
