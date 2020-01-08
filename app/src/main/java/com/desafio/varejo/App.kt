package com.desafio.varejo

import android.app.Application
import com.desafio.varejo.di.presentationModule
import com.desafio.varejo.di.productDetailModule
import com.desafio.varejo.di.productListModule

import com.example.data.di.dataModules
import com.example.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(domainModule + dataModules + listOf(presentationModule, productListModule,productDetailModule))

        }
    }
}