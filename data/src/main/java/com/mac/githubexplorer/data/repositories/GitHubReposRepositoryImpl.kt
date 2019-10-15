package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.data.remote.RepoRemoteDataSource
import com.mac.githubexplorer.domain.entities.RepoDetail
import com.mac.githubexplorer.domain.interfaces.GitHubReposRepository
import io.reactivex.Observable
import io.reactivex.Single

class GitHubReposRepositoryImpl(private val repoRemoteDataSource: RepoRemoteDataSource):
    GitHubReposRepository {
    override fun getStarredRepos(userName: String): Observable<List<Repo>> {
        return repoRemoteDataSource.getStarredRepos(userName)
    }

    override fun getRepoDetails(userName: String, repoName: String): Single<RepoDetail> {
        return repoRemoteDataSource.getRepoDetails(userName, repoName)
    }
}
