package com.desafio.varejo.features.productlist.adapter

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio.varejo.R
import com.desafio.varejo.extensions.inflate
import com.desafio.varejo.utils.CurrencyFormatter
import com.example.domain.entity.Produto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_product.view.*


class ProductListAdapter(
    private val picasso: Picasso,
    private val currencyFormatter: CurrencyFormatter
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    var products: List<Produto> = listOf()

    var onProdutoClick : ((produto: Produto)->Unit)? = null

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.cell_product)) {

        fun bind(produto: Produto) = with(itemView) {
            itemView.setOnClickListener {
                onProdutoClick?.let { it1 -> it1(produto) }
            }
            picasso.load(produto.imagemUrl).into(productImageView)
            nameTextView.text = produto.nome
            currentValueTextView.text = currencyFormatter.format(produto.preco.precoAtual)
            oldValueTextView.text =  currencyFormatter.format(produto.preco.precoAnterior)
            oldValueTextView.paintFlags = oldValueTextView.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun getItemCount(): Int = products.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(products[position])
}