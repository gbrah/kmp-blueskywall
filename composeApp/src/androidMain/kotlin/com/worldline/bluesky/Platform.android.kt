package com.worldline.bluesky

import android.os.Build
import android.util.Log

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


actual class KMPLogger {

    actual companion object {
        actual fun d(message: String){
            Log.d("KMP [Android][Debug] =>",message)
        }
        actual fun e(message: String){
            Log.e("KMP [Android][Error] =>",message)
        }
    }
}