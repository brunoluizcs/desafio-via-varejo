package com.example.domain.usecases

import com.example.domain.entity.ProdutoDetail
import com.example.domain.repository.ProductRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetProductDetailUseCase (
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
){
    fun execute(productId: Int): Single<ProdutoDetail> {
        return productRepository.getProductDetail(productId)
            .subscribeOn(scheduler)
    }
}