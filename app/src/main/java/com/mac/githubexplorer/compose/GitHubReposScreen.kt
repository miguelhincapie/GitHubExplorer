package com.mac.githubexplorer.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mac.githubexplorer.R
import com.mac.githubexplorer.model.RepoListState
import com.mac.githubexplorer.model.RepoRowUI
import com.mac.githubexplorer.theme.GitHubExplorerTheme
import com.mac.githubexplorer.viewmodel.ReposViewModel

@Composable
internal fun GitHubReposScreen(
    viewModel: ReposViewModel = hiltViewModel()
) {
    GitHubExplorerTheme {
        val state by viewModel.state.collectAsStateWithLifecycle()
        val userName = remember { mutableStateOf("") }

        GitHubReposView(
            state,
            userName
        ) { viewModel.fetchStarredRepositories(it) }
    }
}

@Composable
private fun GitHubReposView(
    state: RepoListState,
    userNameState: MutableState<String>,
    onButtonTapped: (String) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (list, button, search) = createRefs()

        Button(
            modifier = Modifier.constrainAs(button) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            onClick = { onButtonTapped.invoke(userNameState.value) },
            enabled = state != RepoListState.Loading
        ) {
            Text(stringResource(id = R.string.search))
        }

        TextField(
            value = userNameState.value,
            placeholder = { Text("Github user name") },
            onValueChange = { userNameState.value = it },
            modifier = Modifier
                .constrainAs(search) {
                    start.linkTo(parent.start)
                    end.linkTo(button.start, 16.dp)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
        )

        val repoListContainerModifier = Modifier.constrainAs(list) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(search.top, 16.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }

        when (state) {
            RepoListState.Loading -> LoadingView(modifier = repoListContainerModifier)
            RepoListState.Empty -> EmptyView(modifier = repoListContainerModifier)
            is RepoListState.ShowingList -> {
                RepoList(
                    modifier = repoListContainerModifier,
                    repoList = state.list
                )
            }
        }
    }
}

@Composable
private fun RepoList(
    modifier: Modifier = Modifier,
    repoList: List<RepoRowUI>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(repoList) {
            RepoRowView(
                uiModel = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4
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
            remember { mutableStateOf("") }
        ) {}
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4
)
private fun GitHubReposViewEmptyPreview() {
    GitHubReposView(
        RepoListState.ShowingList(emptyList()),
        remember { mutableStateOf("") }
    ) {}
}

@Composable
@Preview(
    device = Devices.PIXEL_4
)
private fun GitHubReposViewLoadingPreview() {
    GitHubReposView(
        RepoListState.Loading,
        remember { mutableStateOf("") }
    ) {}
}