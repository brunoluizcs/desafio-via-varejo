package com.example.data.repository

import com.example.data.remote.source.ProductRemoteDataSource
import com.example.domain.entity.ProdutoDetail
import com.example.domain.entity.ProdutoList
import com.example.domain.entity.ProdutoRelated
import com.example.domain.repository.ProductRepository
import io.reactivex.Single


class ProductRepositoryImpl (
    private val productRemoteDataSource: ProductRemoteDataSource
): ProductRepository {
    override fun getProductDetail(productId: Int): Single<ProdutoDetail> {
        return productRemoteDataSource.getProductDetail(productId)
    }

    override fun getProductRelated(productId: Int): Single<List<ProdutoRelated>> {
        return productRemoteDataSource.getProductRelated(productId)
    }

    override fun getProducts(): Single<ProdutoList> {
        return productRemoteDataSource.getProductList()
    }

}