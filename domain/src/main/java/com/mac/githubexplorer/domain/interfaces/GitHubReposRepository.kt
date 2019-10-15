package com.mac.githubexplorer.domain.interfaces

import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.domain.entities.RepoDetail
import io.reactivex.Observable
import io.reactivex.Single

interface GitHubReposRepository {
    fun getStarredRepos(userName: String): Observable<List<Repo>>
    fun getRepoDetails(userName: String, repoName: String): Single<RepoDetail>
}