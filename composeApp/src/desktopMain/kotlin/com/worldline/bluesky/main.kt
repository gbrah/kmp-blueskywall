package com.worldline.bluesky

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "BlueSky Feed") {
        App()
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KMPLogger {
    actual companion object {
        actual fun d(message: String){
            System.out.println("KMP [Desktop][Debug] => $message")
        }

        actual fun e(message: String){
            System.out.println("KMP [Desktop][Error] => $message")
        }
    }
}