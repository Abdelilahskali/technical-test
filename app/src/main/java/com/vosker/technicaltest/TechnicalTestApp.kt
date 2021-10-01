package com.vosker.technicaltest

import android.app.Application
import com.vosker.data.di.dataModule
import com.vosker.domain.di.domainModule
import com.vosker.technicaltest.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TechnicalTestApp: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidLogger(Level.NONE)
            androidContext(applicationContext)
            modules(
                uiModule,
                domainModule,
                dataModule
            )
        }
    }
}