package com.desafio.varejo.features.productlist.viewmodel

import androidx.lifecycle.MutableLiveData
import com.desafio.varejo.viewmodel.BaseViewModel
import com.desafio.varejo.viewmodel.StateMachineSingle
import com.desafio.varejo.viewmodel.ViewState
import com.example.domain.entity.ProdutoList
import com.example.domain.usecases.GetProductsUseCase
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class ProductListViewModel(
    val useCase: GetProductsUseCase,
    val uiScheduler: Scheduler
): BaseViewModel() {

    val state = MutableLiveData<ViewState<ProdutoList>>().apply {
        value = ViewState.Loading
    }

    fun getProducts() {
        disposables += useCase.execute()
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }
}