package dev.mingchungx.notizen.android

import android.app.Application
import dev.mingchungx.notizen.di.androidModule
import dev.mingchungx.notizen.di.initKoin
import dev.mingchungx.notizen.initAppContext

class NotizenApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(androidModule)
        initAppContext(this)
    }
}