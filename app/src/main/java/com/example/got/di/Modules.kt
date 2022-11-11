package com.example.got.di

import com.example.got.model.Retrofit
import com.example.got.repository.Repository
import com.example.got.repository.RepositoryIpl
import com.example.got.view.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single {
        Retrofit.create(androidContext())
    }
}
val numeryRepository = module {
    single<Repository> {
        RepositoryIpl(get())
    }
}
val viewModelModule = module{
    viewModel {
        HomeViewModel(get())
    }
}