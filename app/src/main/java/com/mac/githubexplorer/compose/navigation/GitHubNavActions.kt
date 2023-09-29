package com.mac.githubexplorer.compose.navigation

import androidx.navigation.NavHostController
import com.mac.githubexplorer.compose.navigation.DestinationsArg.REPO_ID
import com.mac.githubexplorer.compose.navigation.Screens.REPOS_SCREEN
import com.mac.githubexplorer.compose.navigation.Screens.REPO_DETAIL

private object Screens {
    const val REPOS_SCREEN = "repos_screen"
    const val REPO_DETAIL = "repo_detail"
}

object DestinationsArg {
    const val REPO_ID = "repoId"
}

object Destinations {
    const val REPOS_ROUTE = REPOS_SCREEN
    const val REPO_DETAIL_ROUTE = "$REPO_DETAIL?$REPO_ID={$REPO_ID}"
}

class GitHubNavActions(private val navHostController: NavHostController) {
}