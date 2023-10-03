package com.mac.githubexplorer.home.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import com.mac.githubexplorer.compose.common.EmptyView
import com.mac.githubexplorer.compose.common.LoadingView
import com.mac.githubexplorer.home.model.HomeState
import com.mac.githubexplorer.home.viewmodel.HomeViewModel
import com.mac.githubexplorer.theme.GitHubExplorerTheme

@Composable
internal fun HomeScreen(
    onStarredReposTapped: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val userName = remember { mutableStateOf("") }

    HomeView(
        state = state,
        userNameState = userName,
        onButtonTapped = { viewModel.getUser(it) },
        onStarredReposTapped = onStarredReposTapped
    )
}

@Composable
private fun HomeView(
    state: HomeState,
    userNameState: MutableState<String>,
    onButtonTapped: (String) -> Unit,
    onStarredReposTapped: (String) -> Unit
) {
    GitHubExplorerTheme {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            val (list, button, search) = createRefs()

            Button(
                modifier = Modifier.constrainAs(button) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                shape = RoundedCornerShape(10),
                onClick = { onButtonTapped.invoke(userNameState.value) },
                enabled = state != HomeState.Loading
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
                HomeState.NoUserSelected -> NoUserSelectedView(modifier = repoListContainerModifier)
                HomeState.Loading -> LoadingView(modifier = repoListContainerModifier)
                HomeState.NoUserFound -> EmptyView(modifier = repoListContainerModifier)
                is HomeState.ShowUserInfo -> {
                    UserView(
                        modifier = repoListContainerModifier,
                        userUI = state.userUI,
                        onStarredReposTapped = onStarredReposTapped
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
private fun HomeViewPreview() {
    HomeView(
        state = HomeState.NoUserSelected,
        userNameState = remember {
            mutableStateOf("")
        },
        onButtonTapped = {},
        onStarredReposTapped = {}
    )
}

@Composable
@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun HomeViewPreviewDark() {
    HomeView(
        state = HomeState.NoUserSelected,
        userNameState = remember {
            mutableStateOf("")
        },
        onButtonTapped = {},
        onStarredReposTapped = {}
    )
}