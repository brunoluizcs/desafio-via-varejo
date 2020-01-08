package com.desafio.varejo.features.productdetail.ui


import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.varejo.R
import com.desafio.varejo.databinding.FragmentDetailBinding
import com.desafio.varejo.extensions.visible
import com.desafio.varejo.features.productdetail.adapter.InformationAdapter
import com.desafio.varejo.features.productdetail.adapter.RelatedListAdapter
import com.desafio.varejo.features.productdetail.viewmodel.ProductDetailViewModel
import com.desafio.varejo.utils.CurrencyFormatter
import com.desafio.varejo.viewmodel.ViewState
import com.example.domain.entity.ProdutoDetail
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val viewModel: ProductDetailViewModel by viewModel()
    private val relatedListAdapter : RelatedListAdapter by inject()
    private val currencyFormatter : CurrencyFormatter by inject()
    private val picasso : Picasso by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        setupViewModel()


        return binding.root
    }

    private fun setupViewModel() {
        viewModel.getProduct(0)

        viewModel.produtoState.observe(this, Observer { state ->
            when (state) {
                is ViewState.Success -> {
                    setupTransactionView(state.data)
                    setupFeaturesView(state.data)
                    setVisibilities(showList = true)
                }
                is ViewState.Loading -> {
                    setVisibilities(showProgressBar = true)
                }
                is ViewState.Failed -> {
                    binding.tvMessage.text = state.throwable.message
                    setVisibilities(showMessage = true)
                }
            }
        })

        viewModel.relatedState.observe(this, Observer {state ->
            when(state){
                is ViewState.Success -> {
                    relatedListAdapter.products = state.data
                    setupRelatedRecyclerView()
                }
                is ViewState.Loading -> {
                    setVisibilities(showProgressBar = true)
                }
                is ViewState.Failed -> {
                    Toast.makeText(context,state.throwable.message,Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    private fun setupTransactionView(produto : ProdutoDetail){
        with(binding.incProductTransaction){
            picasso.load(produto.modelo.padrao.imagens.first().url).into(productImageView)
            productNameTextView.text = produto.nome
            productDescriptionTextView.text = produto.descricao
            oldValueTextView.text = currencyFormatter.format(produto.modelo.padrao.preco.precoAnterior)
            oldValueTextView.paintFlags = oldValueTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

            currentValueTextView.text = currencyFormatter.format(produto.modelo.padrao.preco.precoAtual)
            installmentTextView.text = produto.modelo.padrao.preco.planoPagamento
        }
    }

    private fun setupFeaturesView(produto: ProdutoDetail){
        with(binding.incFeatures){
            featuresRecyclerView.layoutManager = LinearLayoutManager(context)
            featuresRecyclerView.adapter = InformationAdapter().apply { informations = produto.maisInformacoes ?: listOf() }
            featuresRecyclerView.addItemDecoration(DividerItemDecoration(context,RecyclerView.VERTICAL))
        }
    }

    private fun setupRelatedRecyclerView() = with(binding.incRelated.relatedRecyclerView) {
        layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        adapter = relatedListAdapter
    }

    private fun setVisibilities(
        showProgressBar: Boolean = false,
        showList: Boolean = false,
        showMessage: Boolean = false
    ) {
        binding.progressBar.visible(showProgressBar)
        binding.container.visible(showList)
        binding.tvMessage.visible(showMessage)
    }


}
