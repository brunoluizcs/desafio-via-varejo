package com.example.domain.entity

data class Produto (
    val id : Int,
    val sku : Int?,
    val nome : String,
    val disponivel :Boolean,
    val descricao: String,
    val imagemUrl: String?,
    val classificacao: Float,
    val preco : Preco

)