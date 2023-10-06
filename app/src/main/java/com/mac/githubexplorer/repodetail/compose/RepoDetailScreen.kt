package com.mac.githubexplorer.repodetail.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mac.githubexplorer.R
import com.mac.githubexplorer.commons.compose.EmptyView
import com.mac.githubexplorer.commons.compose.LoadingView
import com.mac.githubexplorer.repodetail.model.RepoDetailState
import com.mac.githubexplorer.repodetail.model.RepoDetailUI
import com.mac.githubexplorer.repodetail.viewmodel.RepoDetailViewModel
import com.mac.githubexplorer.theme.GitHubExplorerTheme

@Composable
internal fun RepoDetailScreen(
    userId: String,
    repoId: String,
    viewModel: RepoDetailViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.fetchRepoDetail(userId, repoId)
    }

    when (state) {
        RepoDetailState.Loading -> LoadingView(Modifier.fillMaxSize())
        RepoDetailState.Error -> EmptyView(
            modifier = Modifier.fillMaxSize(),
            text = stringResource(id = R.string.no_repo_found_error)
        )

        is RepoDetailState.ShowingRepoDetail -> RepoDetailView((state as RepoDetailState.ShowingRepoDetail).model)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun RepoDetailView(
    uiModel: RepoDetailUI,
    modifier: Modifier = Modifier
) {
    GitHubExplorerTheme {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 30.sp
                ),
                maxLines = 1,
                text = uiModel.name
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.secondary),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                text = uiModel.description
            )

            Divider(
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.outline),
                maxLines = 1,
                text = String.format(stringResource(id = R.string.license), uiModel.license)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.outline),
                maxLines = 1,
                text = String.format(stringResource(id = R.string.html_url), uiModel.htmlUrl)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.outline),
                maxLines = 1,
                text = String.format(stringResource(id = R.string.home_page), uiModel.homepage)
            )

            Divider(
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.outline),
                maxLines = 1,
                text = String.format(stringResource(id = R.string.language), uiModel.language)
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.tertiary),
                maxLines = 1,
                text = String.format(stringResource(id = R.string.stars), uiModel.stargazersCount)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.tertiary),
                maxLines = 1,
                text = String.format(stringResource(id = R.string.forks), uiModel.forks)
            )

            Divider(
                modifier = Modifier.padding(top = 16.dp)
            )

            FlowRow(
                modifier = Modifier
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(7.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                uiModel.topics.forEach {
                    SuggestionChip(
                        onClick = {},
                        label = { Text(text = it) }
                    )
                }
            }
        }
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true
)
private fun RepoDetailViewPreview() {
    RepoDetailUI(
        name = "Dummy repo name",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",
        license = "Apache-2.0 license",
        language = "Kotlin",
        stargazersCount = "1234",
        htmlUrl = "http://dummy.github.project.url.com",
        homepage = "http://dummy.homepage.project.url.com",
        forks = "12",
        topics = listOf("topic 1", "topic 2", "topic 3", "topic 4", "topic 5")
    ).let {
        RepoDetailView(it)
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun RepoDetailViewPreviewDark() {
    RepoDetailUI(
        name = "Dummy repo name",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",
        license = "Apache-2.0 license",
        language = "Kotlin",
        stargazersCount = "1234",
        htmlUrl = "http://dummy.github.project.url.com",
        homepage = "http://dummy.homepage.project.url.com",
        forks = "12",
        topics = listOf("topic 1", "topic 2", "topic 3", "topic 4", "topic 5")
    ).let {
        RepoDetailView(it)
    }
}