package com.mac.githubexplorer.domain.interfaces

import com.mac.githubexplorer.domain.entities.Repo
import io.reactivex.Observable

interface GitHubReposRepository {
    fun getStarredRepos(userName: String): Observable<List<Repo>>
}