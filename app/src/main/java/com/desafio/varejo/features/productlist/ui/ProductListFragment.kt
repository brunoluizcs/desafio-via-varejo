package com.desafio.varejo.features.productlist.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.varejo.R
import com.desafio.varejo.databinding.FragmentProductListBinding
import com.desafio.varejo.extensions.visible
import com.desafio.varejo.features.productlist.adapter.ProductListAdapter
import com.desafio.varejo.features.productlist.viewmodel.ProductListViewModel
import com.desafio.varejo.viewmodel.ViewState
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductListFragment : Fragment() {

    private val viewModel: ProductListViewModel by viewModel()
    private val productListAdapter : ProductListAdapter by inject()

    private lateinit var binding : FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_product_list,container,false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRecyclerView()

        setupViewModel()

        return binding.root
    }

    private fun setupViewModel() {
        viewModel.getProducts()

        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is ViewState.Success -> {
                    productListAdapter.products = state.data.produtos
                    productListAdapter.onProdutoClick = {produto ->
                        findNavController().navigate(R.id.nav_product_detail, bundleOf("productId" to produto.id))
                    }
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
    }


    private fun setupRecyclerView() = with(binding.recyclerView) {
        layoutManager = GridLayoutManager(context,2)
        adapter = productListAdapter
    }

    private fun setVisibilities(
        showProgressBar: Boolean = false,
        showList: Boolean = false,
        showMessage: Boolean = false
    ) {
        binding.progressBar.visible(showProgressBar)
        binding.recyclerView.visible(showList)
        binding.tvMessage.visible(showMessage)
    }


}
