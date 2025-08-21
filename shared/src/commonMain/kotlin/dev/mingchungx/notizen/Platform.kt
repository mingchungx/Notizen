package dev.mingchungx.notizen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform