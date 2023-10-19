package com.mac.githubexplorer.data.repositories.user.local.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import com.mac.githubexplorer.data.repositories.commons.local.BaseDao
import com.mac.githubexplorer.data.repositories.user.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao : BaseDao<UserEntity> {
    @Query("SELECT * FROM user")
    abstract fun getAll(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE login =:userLogin")
    abstract fun getByLogin(userLogin: String): Flow<UserEntity?>

    @Query("SELECT * FROM user WHERE login =:userLogin")
    abstract suspend fun loadByLogin(userLogin: String): UserEntity?

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    abstract fun loadAllByIds(userIds: List<Int>): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE name LIKE :first LIMIT 1")
    abstract fun findByName(first: String): Flow<UserEntity?>
}