package com.desafio.varejo.di

import com.desafio.varejo.features.productdetail.adapter.RelatedListAdapter
import com.desafio.varejo.features.productdetail.viewmodel.ProductDetailViewModel
import com.desafio.varejo.features.productlist.adapter.ProductListAdapter
import com.desafio.varejo.features.productlist.viewmodel.ProductListViewModel
import com.desafio.varejo.utils.CurrencyFormatter
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single {
        Picasso.get()
    }

    single {
        CurrencyFormatter()
    }
}

val productListModule = module {
    factory {
        ProductListAdapter(picasso = get(), currencyFormatter = get())
    }

    viewModel { ProductListViewModel(
        useCase = get(),
        uiScheduler = AndroidSchedulers.mainThread()
    )
    }
}

val productDetailModule = module {

    factory {
        RelatedListAdapter(picasso = get(), currencyFormatter = get())
    }

    viewModel { ProductDetailViewModel(
        detailUseCase = get(),
        relatedUseCase = get(),
        uiScheduler = AndroidSchedulers.mainThread()
    )
    }
}