package ru.priv.counter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform