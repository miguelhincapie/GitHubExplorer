package com.mac.githubexplorer.domain.usecases

import com.mac.githubexplorer.domain.entities.Feed
import com.mac.githubexplorer.domain.interfaces.FeedRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetFeedListUseCase(private val feedRepository: FeedRepository) {

    operator fun invoke(): Observable<List<Feed>> {
        return feedRepository.getFeedList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}