package dev.mingchungx.notizen.di

import dev.mingchungx.notizen.viewmodel.ContentViewModel
import dev.mingchungx.notizen.repository.GreetingRepository

// koinInject() is not available for iOS so these getter functions provide better ergonomics

// Repositories
fun injectGreetingRepository(): GreetingRepository = getKoin().get()

// View Models
fun injectContentViewModel(): ContentViewModel = getKoin().get()