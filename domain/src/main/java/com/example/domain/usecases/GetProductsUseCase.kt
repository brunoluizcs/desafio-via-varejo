package com.example.domain.usecases

import com.example.domain.entity.Produto
import com.example.domain.entity.ProdutoList
import com.example.domain.repository.ProductRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetProductsUseCase(
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
) {
    fun execute(): Single<ProdutoList> {
        return productRepository.getProducts()
            .subscribeOn(scheduler)
    }
}