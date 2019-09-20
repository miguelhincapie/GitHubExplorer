package com.mac.githubexplorer.data.repositories

import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.data.remote.RepoRemoteDataSource
import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
import io.reactivex.Observable

class GitHubReposRepositoryImpl(private val repoRemoteDataSource: RepoRemoteDataSource):
    GitHubReposRepository {
    override fun getStarredRepos(userName: String): Observable<List<Repo>> {
        return repoRemoteDataSource.getStarredRepos(userName)
    }
}