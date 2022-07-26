package com.example.bloodsugartracking9d.koincomponents

import android.app.Application
import com.example.bloodsugartracking9d.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin


class KoinApplicationclasss : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplicationclasss)
            loadKoinModules(listOf(AppModule.applicationModule()))
            androidLogger()
        }


    }
}