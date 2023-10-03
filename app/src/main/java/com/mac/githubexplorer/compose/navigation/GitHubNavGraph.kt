package com.mac.githubexplorer.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mac.githubexplorer.compose.navigation.DestinationsArg.USER_ID
import com.mac.githubexplorer.compose.repolist.GitHubReposScreen
import com.mac.githubexplorer.home.compose.HomeScreen
import com.mac.githubexplorer.theme.GitHubExplorerTheme

@Composable
fun GitHubNavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.USER_ROUTE,
    navActions: GitHubNavActions = remember(navHostController) {
        GitHubNavActions(navHostController)
    }
) {
    GitHubExplorerTheme {
        NavHost(
            navController = navHostController,
            startDestination = startDestination,
            modifier = Modifier
        ) {
            composable(route = Destinations.USER_ROUTE) {
                HomeScreen(
                    onStarredReposTapped = { navActions.navigateToStarredRepos(it) }
                )
            }
            composable(
                route = Destinations.STARRED_REPOS_ROUTE,
                arguments = listOf(
                    navArgument(USER_ID) { type = NavType.StringType }
                )
            ) {
                val userId = it.arguments?.getString(USER_ID)!!
                GitHubReposScreen(
                    user = userId,
                    onRepoTapped = { repoId ->
                        navActions.navigateToRepoDetail(userId, repoId)
                    }
                )
            }
        }
    }
}