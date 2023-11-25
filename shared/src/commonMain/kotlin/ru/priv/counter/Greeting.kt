package ru.priv.counter

class Greeting {
    private var counter:Int = 0
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}! "
    }

    fun increment(): Int {
        counter += platform.incrementBy
        return counter
    }

    fun getCounter(): String = counter.toString()
}