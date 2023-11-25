package ru.priv.counter

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val incrementBy: Int
        get() = 5
}

actual fun getPlatform(): Platform = IOSPlatform()