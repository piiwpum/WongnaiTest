package com.piiwpum.wongnaitest.di

import com.piiwpum.wongnaitest.data.Repo
import com.piiwpum.wongnaitest.data.RetrofitClient
import com.piiwpum.wongnaitest.ui.view_model.MainViewModel
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient() }
    single { Repo(get()) }
}

val appModule = module {
    single { MainViewModel(get()) }
}
