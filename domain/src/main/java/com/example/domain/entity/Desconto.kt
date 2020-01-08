package com.example.domain.entity

data class Desconto(
    val preco : Float,
    val possuiDesconto : Boolean,
    val descricao : String,
    val porcentagemDesconto : Float
)