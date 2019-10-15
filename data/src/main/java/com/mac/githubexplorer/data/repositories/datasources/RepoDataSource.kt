package com.mac.githubexplorer.data.repositories.datasources

import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.domain.entities.RepoDetail
import io.reactivex.Observable
import io.reactivex.Single

interface RepoDataSource {
    fun getStarredRepos(userName: String): Observable<List<Repo>>
    fun getRepoDetails(userName: String, repoName: String): Single<RepoDetail>
}