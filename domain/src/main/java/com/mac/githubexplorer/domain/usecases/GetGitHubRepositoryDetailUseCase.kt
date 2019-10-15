package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.entities.RepoDetail
import com.mac.githubexplorer.domain.interfaces.GitHubReposRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetGitHubRepositoryDetailUseCase(private val gitHubReposRepository: GitHubReposRepository) {

    operator fun invoke(userName: String, repoName: String): Single<RepoDetail> {
        return gitHubReposRepository.getRepoDetails(userName, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}