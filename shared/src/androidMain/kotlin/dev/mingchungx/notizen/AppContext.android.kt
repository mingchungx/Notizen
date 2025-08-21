package dev.mingchungx.notizen

import android.content.Context

lateinit var appContext: Context

fun initAppContext(context: Context) {
    appContext = context.applicationContext
}
