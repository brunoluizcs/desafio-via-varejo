package com.example.domain.entity

data class Marketplace(
    val maiorPreco: Float,
    val menorPreco : Float,
    val lojistaPadrao: Lojista,
    val lojistasEmDestaque : List<Lojista>?,
    val preco: Preco

)
