package com.desafio.varejo.features.productdetail.adapter

import android.graphics.Paint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio.varejo.R
import com.desafio.varejo.extensions.inflate
import com.desafio.varejo.utils.CurrencyFormatter
import com.example.domain.entity.ProdutoRelated
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_product.view.*

class RelatedListAdapter(
    private val picasso: Picasso,
    private val currencyFormatter: CurrencyFormatter
) : RecyclerView.Adapter<RelatedListAdapter.ViewHolder>() {

    var products: List<ProdutoRelated> = listOf()

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.cell_product)) {

        fun bind(produto: ProdutoRelated) = with(itemView) {
            itemView.container.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )


            picasso.load(produto.imagemUrl).into(productImageView)
            nameTextView.text = produto.nome
            currentValueTextView.text = currencyFormatter.format(produto.precoAtual)
            oldValueTextView.text =  currencyFormatter.format(produto.precoAnterior)
            oldValueTextView.paintFlags = oldValueTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun getItemCount(): Int = products.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(products[position])
}