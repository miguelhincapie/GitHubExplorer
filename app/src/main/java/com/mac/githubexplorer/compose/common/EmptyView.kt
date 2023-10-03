package com.mac.githubexplorer.compose.common

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mac.githubexplorer.R
import com.mac.githubexplorer.theme.GitHubExplorerTheme
import com.mac.githubexplorer.theme.seed

@Composable
internal fun EmptyView(
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.empty_repos_description)
) {
    GitHubExplorerTheme {
        Column(
            modifier = modifier.background(color = MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(220.dp),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.emoji_dizzy_fill),
                contentDescription = text,
                colorFilter = if (isSystemInDarkTheme().not()) {
                    ColorFilter.tint(seed)
                } else null
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = text,
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.secondary)
            )
        }
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true
)
internal fun EmptyViewPreview() {
    EmptyView(Modifier.fillMaxSize())
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun EmptyViewPreviewDark() {
    EmptyView(Modifier.fillMaxSize())
}