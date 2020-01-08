package com.example.domain.usecases

import com.example.domain.entity.ProdutoRelated
import com.example.domain.repository.ProductRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetProductRelatedUseCase(
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
) {
    fun execute(productId: Int): Single<List<ProdutoRelated>> {
        return productRepository.getProductRelated(productId)
            .subscribeOn(scheduler)
    }
}