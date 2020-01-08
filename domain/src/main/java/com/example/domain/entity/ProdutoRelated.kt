package com.example.domain.entity

data class ProdutoRelated(
    val id: Int,
    val sku: Int,
    val nome: String,
    val imagemUrl: String,
    val precoAtual: Float,
    val precoAnterior: Float,
    val percentualCompra: Float,
    val classificacao: Float,
    val parcelamento: String
)