package com.piiwpum.wongnaitest

import android.app.Application
import com.piiwpum.wongnaitest.di.appModule
import com.piiwpum.wongnaitest.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoinApplication)
            modules(networkModule, appModule)
        }
    }
}