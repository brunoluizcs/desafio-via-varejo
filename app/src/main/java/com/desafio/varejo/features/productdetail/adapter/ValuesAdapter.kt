package com.desafio.varejo.features.productdetail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio.varejo.R
import com.desafio.varejo.extensions.inflate
import com.example.domain.entity.Valor
import kotlinx.android.synthetic.main.cell_values.view.*


class ValuesAdapter(private val valores : List<Valor>?) : RecyclerView.Adapter<ValuesAdapter.ViewHolder>() {


    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.cell_values)) {

        fun bind(valor: Valor?) = with(itemView) {
            nameTextView.text = valor?.nome
            valueTextView.text = valor?.valor
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun getItemCount(): Int = valores?.size ?: 0
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(valores?.get(position))
}