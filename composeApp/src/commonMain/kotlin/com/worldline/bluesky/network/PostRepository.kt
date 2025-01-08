package com.worldline.bluesky.network

import com.worldline.bluesky.network.data.BlueSkyStaticUserInfos
import com.worldline.bluesky.network.data.Post
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PostRepository(private val api: BlueSkyDataSource) {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: Flow<List<Post>> = _posts.asStateFlow()

    private suspend fun refreshPosts(actor: String) {
        val response = api.getAuthorFeed(actor)
        _posts.value = response.feed.map { it.post!! }
    }

    suspend fun startAutoRefresh(actor: String ) {
               api.createSession(BlueSkyStaticUserInfos.ACTOR, BlueSkyStaticUserInfos.PASSWORD)
                while (true) {
                    refreshPosts(actor)
                    delay(1800000)// Refresh every 30 seconds
                }
    }
}