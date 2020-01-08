package com.example.domain.entity

data class ProdutoDetail (
    val id : Int,
    val nome : String,
    val descricao : String,
    val retiraEmLoja : Boolean,
    val categorias : List<Categoria>,
    val maisInformacoes : List<Informacao>?,
    val marca : Marca,
    val modelo : Modelo,
    val urlVideo : String?
)