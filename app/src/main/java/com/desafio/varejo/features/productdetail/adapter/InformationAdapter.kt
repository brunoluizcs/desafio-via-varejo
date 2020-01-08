package com.desafio.varejo.features.productdetail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.varejo.R
import com.desafio.varejo.extensions.inflate
import com.example.domain.entity.Informacao
import kotlinx.android.synthetic.main.cell_information.view.*

class InformationAdapter() : RecyclerView.Adapter<InformationAdapter.ViewHolder>() {

    var informations: List<Informacao> = listOf()

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.cell_information)) {

        fun bind(informacao: Informacao) = with(itemView) {
            nameTextView.text = informacao.descricao
            valuesRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            valuesRecyclerView.adapter = ValuesAdapter(informacao.valores)
            valuesRecyclerView.addItemDecoration(DividerItemDecoration(context,RecyclerView.VERTICAL))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun getItemCount(): Int = informations.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(informations[position])
}