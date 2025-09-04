package dev.mingchungx.notizen.repository

import io.ktor.client.HttpClient

interface GreetingRepository {
    suspend fun fetchGetting(): String

    class Impl(private val client: HttpClient): GreetingRepository {
        private val _name: String = "GreetingRepository"

        override suspend fun fetchGetting(): String {
            return "Hello from GreetingRepository"
        }
    }
}