package ru.priv.counter

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val incrementBy: Int
        get() = 10
}

actual fun getPlatform(): Platform = AndroidPlatform()