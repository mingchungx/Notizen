package dev.mingchungx.notizen.di

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import com.russhwolf.settings.Settings

val coreModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true; prettyPrint = false })
            }
        }
    }
    single<Settings> { Settings() } // multiplatform default
}