package com.mac.githubexplorer.home.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.mac.githubexplorer.R
import com.mac.githubexplorer.home.model.UserUI
import com.mac.githubexplorer.theme.GitHubExplorerTheme
import com.mac.githubexplorer.theme.seed

@Composable
internal fun UserView(
    modifier: Modifier,
    userUI: UserUI,
    onStarredReposTapped: (String) -> Unit
) {
    GitHubExplorerTheme {
        Column(
            modifier = modifier.background(color = MaterialTheme.colorScheme.surface)
        ) {
            Image(
                modifier = Modifier
                    .size(220.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp),
                bitmap = userUI.avatar.toBitmap(220, 220).asImageBitmap(),
                contentDescription = stringResource(R.string.user_avatar)
            )

            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = userUI.visualName,
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.secondary)
            )

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = userUI.accountName,
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.tertiary)
            )

            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = userUI.description,
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.secondary)
            )

            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.people),
                    contentDescription = null,
                    colorFilter = if (isSystemInDarkTheme().not()) {
                        ColorFilter.tint(seed)
                    } else null
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = userUI.followers,
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.secondary)
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = userUI.following,
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.secondary)
                )
            }

            Divider(
                modifier = Modifier.padding(top = 20.dp)
            )

            Button(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 30.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(10),
                onClick = { onStarredReposTapped.invoke(userUI.accountName) }
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.star_fill),
                        contentDescription = null,
                        colorFilter = if (isSystemInDarkTheme()) {
                            ColorFilter.tint(seed)
                        } else null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = stringResource(id = R.string.starred_button))
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
private fun UserViewPreview() {
    UserView(
        modifier = Modifier,
        userUI = UserUI(
            avatar = LocalContext.current.getDrawable(R.drawable.github)!!,
            visualName = "Dummy visual name",
            accountName = "Account name",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            followers = "30 followers",
            following = "20 following"
        )
    ) {}
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun UserViewPreviewDark() {
    UserView(
        modifier = Modifier,
        userUI = UserUI(
            avatar = LocalContext.current.getDrawable(R.drawable.github)!!,
            visualName = "Dummy visual name",
            accountName = "Account name",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            followers = "30 followers",
            following = "20 following"
        )
    ) {}
}