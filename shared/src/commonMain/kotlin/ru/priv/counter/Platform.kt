package ru.priv.counter

interface Platform {
    val name: String
    val incrementBy: Int
}

expect fun getPlatform(): Platform