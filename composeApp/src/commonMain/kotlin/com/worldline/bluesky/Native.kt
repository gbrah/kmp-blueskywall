package com.worldline.bluesky

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KMPLogger {
    companion object {
        fun d(message: String)
        fun e(message: String)
    }
}