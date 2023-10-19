package com.mac.githubexplorer.data.repositories.user.local.datasource

import com.mac.githubexplorer.data.repositories.user.local.datasource.dao.UserDao
import com.mac.githubexplorer.data.repositories.user.local.mapper.UserLocalMapper
import com.mac.githubexplorer.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
    private val userLocalMapper: UserLocalMapper
) : UserLocalDataSource {
    override suspend fun loadUser(userName: String): User? {
        return userDao.loadByLogin(userName)?.let {
            userLocalMapper.userToDomain(it)
        }
    }

    /**
     * Use distinctUntilChanged() when exposing a flow from DB
     * "Room only knows that the table has been modified but doesn't know why and what has changed.
     * Therefore, after the re-query, the result of the query is emitted by the LiveData or Flowable.
     * Since Room doesn't hold any data in memory and can’t assume that objects have equals(),
     * it can't tell whether this is the same data or not."
     * More info: https://medium.com/androiddevelopers/7-pro-tips-for-room-fbadea4bfbd1
     */
    override fun getUser(userName: String): Flow<User?> {
        return userDao.getByLogin(userName).distinctUntilChanged().map { nullableResponse ->
            nullableResponse?.let { userLocalMapper.userToDomain(it) }
        }
    }

    override suspend fun saveUser(user: User) {
        userLocalMapper.userToLocal(user).let {
            userDao.insert(it)
        }
    }
}