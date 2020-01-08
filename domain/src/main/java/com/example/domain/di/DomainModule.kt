package com.example.domain.di

import com.example.domain.usecases.GetProductDetailUseCase
import com.example.domain.usecases.GetProductRelatedUseCase
import com.example.domain.usecases.GetProductsUseCase
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductsUseCase(
            productRepository = get(),
            scheduler = Schedulers.io()
        )
    }

    factory {
        GetProductDetailUseCase(
            productRepository = get(),
            scheduler = Schedulers.io()
        )
    }

    factory {
        GetProductRelatedUseCase(
            productRepository = get(),
            scheduler = Schedulers.io()
        )
    }


}

val domainModule = listOf(useCaseModule)