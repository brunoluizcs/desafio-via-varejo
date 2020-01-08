package com.example.data.remote.api


import com.example.domain.entity.ProdutoDetail
import com.example.domain.entity.ProdutoList
import com.example.domain.entity.ProdutoRelated
import io.reactivex.Single
import retrofit2.http.GET

interface ProductAPI {
    @GET("/v2/5d1b4f0f34000074000006dd")
    fun getProdutoList(): Single<ProdutoList>

    @GET("/v2/5d1b4fd23400004c000006e1")
    fun getProdutoDetail(): Single<ProdutoDetail>

    @GET("/v2/5d1b507634000054000006ed")
    fun getProdutoRelated(): Single<List<ProdutoRelated>>
}
