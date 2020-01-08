package com.example.domain.entity

data class Servico(
    val nome : String,
    val sku : Int,
    val idLojista: Int,
    val preco : Float,
    val parcelamento : String,
    val tipo : String
)