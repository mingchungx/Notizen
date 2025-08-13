package com.example.notizen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform