package com.mac.githubexplorer.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mac.githubexplorer.compose.repolist.GitHubReposScreen
import com.mac.githubexplorer.theme.GitHubExplorerTheme

@Composable
fun GitHubNavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.REPOS_ROUTE,
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
            composable(route = Destinations.REPOS_ROUTE) {
                GitHubReposScreen()
            }
        }
    }
}