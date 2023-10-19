package com.mac.githubexplorer.data.repositories.repo.local.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import com.mac.githubexplorer.data.repositories.commons.local.BaseDao
import com.mac.githubexplorer.data.repositories.repo.local.entity.RepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RepoDao : BaseDao<RepoEntity> {
    @Query("SELECT * FROM repo")
    abstract fun getAll(): Flow<List<RepoEntity>>

    @Query("SELECT * FROM repo WHERE name =:repoName")
    abstract fun getByName(repoName: String): Flow<RepoEntity>

    @Query("SELECT * FROM repo WHERE name =:repoName")
    abstract suspend fun loadByName(repoName: String): RepoEntity?

    @Query("SELECT * FROM repo WHERE name LIKE :first LIMIT 1")
    abstract fun findByName(first: String): Flow<RepoEntity>
}