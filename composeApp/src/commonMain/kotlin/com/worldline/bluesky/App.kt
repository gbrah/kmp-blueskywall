package com.worldline.bluesky

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.worldline.bluesky.network.BlueSkyDataSource
import com.worldline.bluesky.network.data.BlueSkyStaticUserInfos
import com.worldline.bluesky.network.data.Post
import com.worldline.bluesky.network.PostRepository
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
@Preview
fun App( viewModel: PostViewModel = viewModel { PostViewModel(PostRepository(BlueSkyDataSource())) }) {

    MaterialTheme {
        Surface {
            PostWall(viewModel, BlueSkyStaticUserInfos.FEED_AUTHOR)
        }
    }
}

@Composable
fun PostWall(viewModel: PostViewModel, actor: String) {
    // Start auto-refreshing posts
    LaunchedEffect(Unit) {
        viewModel.startAutoRefresh(actor)
    }

    val posts by viewModel.posts.collectAsState(emptyList())

    if(posts.isNotEmpty()){

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text( text = "@$actor", style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(5.dp))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(400.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(posts) { post ->
                PostCard(post)
            }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
}

@Composable
fun PostCard(post: Post) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            val thumbUrl = post.embed?.images?.firstOrNull()?.thumb ?: post.embed?.external?.thumb
            thumbUrl?.let { thumb ->
                KMPLogger.d(thumb)
                AsyncImage(
                model = thumb,
                contentDescription = null,
                onError = { error -> KMPLogger.e(error.toString()) }
                )
            }
            Text(text = post.author!!.displayName!!, style = MaterialTheme.typography.h6)
            post.author?.createdAt?.let { Text(text = formatDate(it)  , style = MaterialTheme.typography.subtitle2) }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = post.record!!.text!!, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }


}
    fun formatDate(dateString: String): String {
        val instant = Instant.parse(dateString) // Parse the ISO 8601 date string
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault()) // Convert to local date time
        return "${localDateTime.date} ${localDateTime.hour}:${localDateTime.minute}" // Format the date
    }




