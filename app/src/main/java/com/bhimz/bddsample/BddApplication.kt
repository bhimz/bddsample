package com.bhimz.bddsample

import android.app.Application
import com.bhimz.bddsample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BddApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BddApplication)
            modules(listOf(appModule))
        }
    }
}