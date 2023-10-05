package com.mac.githubexplorer.starredrepos.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mac.githubexplorer.starredrepos.model.RepoRowUI
import com.mac.githubexplorer.theme.GitHubExplorerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RepoRowView(
    modifier: Modifier = Modifier,
    uiModel: RepoRowUI,
    onRepoTapped: (String) -> Unit
) {
    GitHubExplorerTheme {
        Card(
            modifier = modifier.background(color = MaterialTheme.colorScheme.surface),
            onClick = { onRepoTapped.invoke(uiModel.name) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    text = uiModel.name
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    text = uiModel.description
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    text = uiModel.language
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.tertiary),
                    maxLines = 1,
                    text = uiModel.stargazersCount
                )
            }
        }
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true
)
private fun RepoRowViewPreview() {
    RepoRowUI(
        name = "Repo name dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        language = "Language: Kotlin",
        stargazersCount = "Stars: 1234"
    ).let {
        RepoRowView(uiModel = it) {}
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun RepoRowViewPreviewDark() {
    RepoRowUI(
        name = "Repo name dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        language = "Language: Kotlin",
        stargazersCount = "Stars: 1234"
    ).let {
        RepoRowView(uiModel = it) {}
    }
}