package com.worldline.bluesky.network

import com.worldline.bluesky.network.data.CreateSessionRequest
import com.worldline.bluesky.network.data.CreateSessionResponse
import com.worldline.bluesky.network.data.PostData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class BlueSkyDataSource {

    private var accessToken = ""

     private val client = HttpClient {
         defaultRequest {
             url("https://api.bsky.social/xrpc/")
         }
         install(ContentNegotiation) {
            json(
                //contentType = ContentType.Text.Plain, // because Github is not returning an 'application/json' header
                json = Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
            })
    }
         install(Logging) {
             logger = Logger.SIMPLE
             level = LogLevel.BODY
         }

    }

    suspend fun createSession(identifier: String, password: String) {
        val request = CreateSessionRequest(identifier, password)
        val session: CreateSessionResponse = client.post("com.atproto.server.createSession"){
            contentType(ContentType.Application.Json)
            setBody(request)

        }.body()
        accessToken=session.accessJwt
    }

    suspend fun getAuthorFeed(actor: String): PostData {
        return client.get("app.bsky.feed.getAuthorFeed"){
            parameter("actor", actor)
            header(HttpHeaders.Authorization, "Bearer $accessToken")
        }.body()
    }
}