package com.example.domain.entity

data class Padrao (
  val sky : Int,
  val nome : String,
  val disponivel : Boolean,
  val marketplace: Marketplace,
  val preco : Preco,
  val imagens: List<Imagem>,
  val servicos : List<Servico>


)
