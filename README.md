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

## API Reference

###   Request Auth Token

To create a session, send a POST request to the following endpoint:

```bash
curl -X POST "https://api.bsky.social/xrpc/com.atproto.server.createSession" \
-H "Content-Type: application/json" \
-d '{
  "identifier": "user@example.com",
  "password": "your_password_here"
}'  
```

### Response Example

```json
{
  "did": "did:plc:exampledid",
  "handle": "user.bsky.social",
  "emailConfirmed": true,
  "accessJwt": "your_access_jwt_here",
  "refreshJwt": "your_refresh_jwt_here",
  "active": true
}
```

---

# Request Feed

To retrieve the author's feed, send a GET request to the following endpoint:

```bash
curl -X GET "https://api.bsky.social/xrpc/app.bsky.feed.getAuthorFeed?actor=user.bsky.social" \
-H "Content-Type: application/json" \
-H "Authorization: Bearer your_access_jwt_here"
```

### Response Example

```json
{
  "feed": [
    {
      ...
```

## Usage

* You can deploy it on an android based terminal, Raspberry that can be projected during your event.
* or a Raspberry pi 4 , you can download your IMG [here](https://konstakang.com/devices/rpi4/AOSP13/) and use ADB to push the APK


## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

