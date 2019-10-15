package com.mac.githubexplorer.data.remote

import com.mac.githubexplorer.data.remote.api.GitHubReposService
import com.mac.githubexplorer.data.repositories.datasources.RepoDataSource
import com.mac.githubexplorer.data.repositories.toRepo
import com.mac.githubexplorer.data.repositories.toRepoDetail
import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.domain.entities.RepoDetail
import io.reactivex.Observable
import io.reactivex.Single

class RepoRemoteDataSource(private val gitHubReposService: GitHubReposService) : RepoDataSource {
    override fun getStarredRepos(userName: String): Observable<List<Repo>> {
        return gitHubReposService.getStarredRepositories(userName).flatMap {
            Observable.fromIterable(it)
                .map { repoNetwork -> repoNetwork.toRepo() }
                .toList()
                .toObservable()
        }
    }

    override fun getRepoDetails(userName: String, repoName: String): Single<RepoDetail> {
        return gitHubReposService.getRepoDetails(userName, repoName).map { it.toRepoDetail() }
    }
}