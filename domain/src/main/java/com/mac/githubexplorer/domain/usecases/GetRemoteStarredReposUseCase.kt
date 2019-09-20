package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.domain.repositories.GitHubReposRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetRemoteStarredReposUseCase(private val gitHubRepository: GitHubReposRepository) {

    operator fun invoke(userName: String): Observable<List<Repo>> {
        return gitHubRepository.getStarredRepos(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}