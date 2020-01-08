package com.example.data.remote.source

import com.example.data.remote.api.ProductAPI
import com.example.domain.entity.ProdutoDetail
import com.example.domain.entity.ProdutoList
import com.example.domain.entity.ProdutoRelated
import io.reactivex.Single

class ProductRemoteDataSourceImpl(private val productAPI: ProductAPI) : ProductRemoteDataSource {

    override fun getProductList(): Single<ProdutoList> {
        return productAPI.getProdutoList()
    }

    override fun getProductDetail(productId: Int): Single<ProdutoDetail> {
        return productAPI.getProdutoDetail()
    }

    override fun getProductRelated(productId: Int): Single<List<ProdutoRelated>> {
        return productAPI.getProdutoRelated()
    }

}