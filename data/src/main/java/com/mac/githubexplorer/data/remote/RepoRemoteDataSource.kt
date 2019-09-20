package com.mac.githubexplorer.data.remote

import com.mac.githubexplorer.data.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.datasources.RepoDataSource
import com.mac.githubexplorer.domain.entities.Repo
import io.reactivex.Observable

class RepoRemoteDataSource(private val gitHubReposService: GitHubReposService) : RepoDataSource {
    override fun getStarredRepos(userName: String): Observable<List<Repo>> {
        return gitHubReposService.getStarredRepositories(userName)
    }
}