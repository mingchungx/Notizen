package dev.mingchungx.notizen.di

import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

private var koinApp: Koin? = null

fun initKoin(vararg extra: Module): Koin {
    stopKoin() // ensure fresh graph
    val app = startKoin {
        modules(
            coreModule,
            repositoryModule,
            viewModelModule,
            *extra
        )
    }.koin
    koinApp = app
    return app
}

fun getKoin(): Koin =
    koinApp ?: error("Koin not initialized")
