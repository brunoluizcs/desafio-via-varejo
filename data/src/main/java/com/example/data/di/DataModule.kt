package com.example.data.di

import com.example.data.repository.ProductRepositoryImpl
import com.example.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ProductRepository> {
        ProductRepositoryImpl(
            productRemoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule)
