package com.example.domain.repository

import com.example.domain.entity.ProdutoDetail
import com.example.domain.entity.ProdutoList
import com.example.domain.entity.ProdutoRelated
import io.reactivex.Single

interface ProductRepository {

    fun getProducts(): Single<ProdutoList>
    fun getProductDetail(productId: Int) : Single<ProdutoDetail>
    fun getProductRelated(productId: Int) : Single<List<ProdutoRelated>>

}