package dev.mingchungx.notizen.di

import dev.mingchungx.notizen.viewmodel.ContentViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { ContentViewModel(get()) }
}