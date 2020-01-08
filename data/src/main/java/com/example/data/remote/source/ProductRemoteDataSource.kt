package com.example.data.remote.source

import com.example.domain.entity.Produto
import com.example.domain.entity.ProdutoDetail
import com.example.domain.entity.ProdutoList
import com.example.domain.entity.ProdutoRelated
import io.reactivex.Single

interface ProductRemoteDataSource {

    fun getProductList() : Single<ProdutoList>
    fun getProductDetail(productId : Int) : Single<ProdutoDetail>
    fun getProductRelated(productId : Int) : Single<List<ProdutoRelated>>

}