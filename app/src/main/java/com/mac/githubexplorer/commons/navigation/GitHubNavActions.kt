package com.mac.githubexplorer.commons.navigation

import androidx.navigation.NavHostController
import com.mac.githubexplorer.commons.navigation.DestinationsArg.REPO_ID
import com.mac.githubexplorer.commons.navigation.DestinationsArg.USER_ID
import com.mac.githubexplorer.commons.navigation.Screens.REPO_DETAIL_SCREEN
import com.mac.githubexplorer.commons.navigation.Screens.STARRED_REPOS_SCREEN
import com.mac.githubexplorer.commons.navigation.Screens.USER_SCREEN

private object Screens {
    const val USER_SCREEN = "user_screen"
    const val STARRED_REPOS_SCREEN = "starred_repos_screen"
    const val REPO_DETAIL_SCREEN = "repo_detail"
}

object DestinationsArg {
    const val USER_ID = "userId"
    const val REPO_ID = "repoId"
}

object Destinations {
    const val USER_ROUTE = USER_SCREEN
    const val STARRED_REPOS_ROUTE = "$STARRED_REPOS_SCREEN/{$USER_ID}"
    const val REPO_DETAIL_ROUTE = "$REPO_DETAIL_SCREEN/{$USER_ID}/{$REPO_ID}"
}

class GitHubNavActions(private val navHostController: NavHostController) {
    fun navigateToStarredRepos(user: String) {
        navHostController.navigate("$STARRED_REPOS_SCREEN/$user")
    }

    fun navigateToRepoDetail(user: String, repoName: String) {
        navHostController.navigate("$REPO_DETAIL_SCREEN/$user/$repoName")
    }
}