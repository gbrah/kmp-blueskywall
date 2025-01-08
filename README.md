# Bluesky Social Feed

## Overview

This is a simple Kotlin Multiplatform Mobile (KMP) application 
that displays a list of posts from a Bluesky social feed based on a hardcoded username. 
The app is designed to showcase content on an Android phone, making it perfect 
for tech conferences and events where you want to project live social media updates.

## Features

- Displays a list of posts from a specified BlueSky user.
- Ideal for projecting live updates during tech conferences or a sponsor booth.

## Getting Started

1. Clone the repository.
2. Fill in the BlueSkyStaticUserInfos.kt file with your BlueSky user information.

```Kotlin
/* Enter your username and password here created on https://bsky.app/ */
class BlueSkyStaticUserInfos {
    companion object {
        const val ACTOR = "<PUT_YOUR_USERNAME_HERE>"
        const val PASSWORD = "<PUT_YOUR_PASSWORD_HERE>"
        const val FEED_AUTHOR = "<PUT_YOUR_FOLLOWER_USERNAME_HERE>"
    }
}
```

![Screenshot](screenshot.png)

