package com.desafio.varejo.features.productdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.desafio.varejo.viewmodel.BaseViewModel
import com.desafio.varejo.viewmodel.StateMachineSingle
import com.desafio.varejo.viewmodel.ViewState
import com.example.domain.entity.ProdutoDetail
import com.example.domain.entity.ProdutoRelated
import com.example.domain.usecases.GetProductDetailUseCase
import com.example.domain.usecases.GetProductRelatedUseCase
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class ProductDetailViewModel(
    private val detailUseCase: GetProductDetailUseCase,
    private val relatedUseCase: GetProductRelatedUseCase,
    private val uiScheduler: Scheduler
) : BaseViewModel() {
    val produtoState = MutableLiveData<ViewState<ProdutoDetail>>().apply {
        value = ViewState.Loading
    }

    val relatedState = MutableLiveData<ViewState<List<ProdutoRelated>>>().apply {
        value = ViewState.Loading
    }

    fun getProduct(productId: Int) {
        disposables += detailUseCase.execute(productId)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    produtoState.postValue(it)
                },
                {
                    //onError
                }
            )

        disposables += relatedUseCase.execute(productId)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    relatedState.postValue(it)
                },
                {
                    //onError
                }
            )
    }
}