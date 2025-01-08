package com.worldline.bluesky

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.bluesky.network.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    val posts = repository.posts

    fun startAutoRefresh(actor: String) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.startAutoRefresh(actor)
        }
    }
}