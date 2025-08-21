package dev.mingchungx.notizen.android

import android.app.Application
import dev.mingchungx.notizen.initAppContext

class NotizenApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initAppContext(this)
    }
}