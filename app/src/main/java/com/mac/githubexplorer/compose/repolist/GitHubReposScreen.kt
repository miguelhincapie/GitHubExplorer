package com.mac.githubexplorer.compose.repolist

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mac.githubexplorer.compose.common.EmptyView
import com.mac.githubexplorer.compose.common.LoadingView
import com.mac.githubexplorer.model.RepoListState
import com.mac.githubexplorer.model.RepoRowUI
import com.mac.githubexplorer.theme.GitHubExplorerTheme
import com.mac.githubexplorer.viewmodel.ReposViewModel

@Composable
internal fun GitHubReposScreen(
    user: String,
    onRepoTapped: (String) -> Unit,
    viewModel: ReposViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel.fetchStarredRepositories(user)

    GitHubReposView(
        state = state,
        onRepoTapped = onRepoTapped
    )
}

@Composable
private fun GitHubReposView(
    state: RepoListState,
    onRepoTapped: (String) -> Unit
) {
    GitHubExplorerTheme {
        val modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(16.dp)
        when (state) {
            RepoListState.Loading -> LoadingView(modifier)
            RepoListState.Empty -> EmptyView(modifier)
            is RepoListState.ShowingList -> {
                RepoList(
                    modifier = modifier,
                    repoList = state.list,
                    onRepoTapped = onRepoTapped
                )
            }
        }
    }
}

@Composable
private fun RepoList(
    modifier: Modifier = Modifier,
    repoList: List<RepoRowUI>,
    onRepoTapped: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(repoList) {
            RepoRowView(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 16.dp),
                uiModel = it,
                onRepoTapped = onRepoTapped
            )
        }
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true
)
private fun GitHubReposViewPreview() {
    listOf(
        RepoRowUI(
            name = "Repo name dummy 1",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            language = "Kotlin",
            stargazersCount = "1234"
        ),
        RepoRowUI(
            name = "Repo name dummy 2",
            description = "Lorem Ipsum is simply dummy",
            language = "Kotlin",
            stargazersCount = "4321"
        ),
        RepoRowUI(
            name = "Repo name dummy 3",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard",
            language = "Kotlin",
            stargazersCount = "1"
        ),
        RepoRowUI(
            name = "Repo name dummy 4",
            description = "Lorem Ipsum is simply dummy",
            language = "Kotlin",
            stargazersCount = "22"
        )
    ).let {
        GitHubReposView(
            RepoListState.ShowingList(it),
        ) {}
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true
)
private fun GitHubReposViewEmptyPreview() {
    GitHubReposView(
        RepoListState.Empty,
    ) {}
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true
)
private fun GitHubReposViewLoadingPreview() {
    GitHubReposView(
        RepoListState.Loading,
    ) {}
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun GitHubReposViewPreviewDark() {
    listOf(
        RepoRowUI(
            name = "Repo name dummy 1",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            language = "Kotlin",
            stargazersCount = "1234"
        ),
        RepoRowUI(
            name = "Repo name dummy 2",
            description = "Lorem Ipsum is simply dummy",
            language = "Kotlin",
            stargazersCount = "4321"
        ),
        RepoRowUI(
            name = "Repo name dummy 3",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard",
            language = "Kotlin",
            stargazersCount = "1"
        ),
        RepoRowUI(
            name = "Repo name dummy 4",
            description = "Lorem Ipsum is simply dummy",
            language = "Kotlin",
            stargazersCount = "22"
        )
    ).let {
        GitHubReposView(
            RepoListState.ShowingList(it),
        ) {}
    }
}