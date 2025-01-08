package com.worldline.bluesky


import platform.Foundation.NSLog
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual class KMPLogger {
    actual companion object {
        actual fun d(message: String){
            println("KMP [iOS][Debug] => $message")
        }

        actual fun e(message: String){
            println("KMP [iOS][Error] => $message")
        }
    }
}