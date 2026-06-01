package com.pdm0126.votacionesuca.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = viewModel(), onNext: () -> Unit) {
    val posts by viewModel.votes.collectAsState()
    val refresh by viewModel.refreshing.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("RankeUca - Vota") },
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            PullToRefreshBox(
                isRefreshing = refresh,
                onRefresh = { viewModel.onRefresh() },
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    items(posts) { post ->

                        Card(
                            modifier = Modifier
                                .padding(bottom = 12.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(text = "$post.id")
                                Text(text = "$post.votes")
                                Text(text = "${post.name}")
                                AsyncImage(
                                    model = post.imageUrl,
                                    contentDescription = null,
                                    modifier = Modifier.size(80.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
                Button(
                    onClick = { onNext() },
                    modifier = Modifier.align(alignment = Alignment.BottomCenter)
                ) {
                    Text(text = "Pasar a resultados")
                }
            }
        }
    }
}