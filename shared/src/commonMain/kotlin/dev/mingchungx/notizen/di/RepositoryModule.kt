package dev.mingchungx.notizen.di

import dev.mingchungx.notizen.repository.GreetingRepository
import org.koin.dsl.module

val repositoryModule = module {
    // Repositories are typically singletons
    single<GreetingRepository> { GreetingRepository.Impl(get()) }
}