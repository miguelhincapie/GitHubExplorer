package com.mac.githubexplorer.data.repositories.datasources

import com.mac.githubexplorer.domain.entities.Repo
import io.reactivex.Observable

interface RepoDataSource {
    fun getStarredRepos(userName: String): Observable<List<Repo>>
}