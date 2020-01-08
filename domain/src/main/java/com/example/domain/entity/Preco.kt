package com.example.domain.entity

data class Preco (
    val planoPagamento: String,
    val valorParcela: Float,
    val quantidadeMaximaParcelas: Int,
    val precoAtual: Float,
    val precoAnterior: Float,
    val porcentagemDesconto: Int,
    val descontoFormaPagamento : Desconto?
)