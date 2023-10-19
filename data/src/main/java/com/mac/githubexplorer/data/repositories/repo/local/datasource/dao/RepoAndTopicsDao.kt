package com.mac.githubexplorer.data.repositories.repo.local.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.mac.githubexplorer.data.repositories.repo.local.entity.RepoAndTopics
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoAndTopicsDao {

    @Transaction
    @Query("SELECT * FROM repo")
    suspend fun getAllRepoWithTopics(): Flow<List<RepoAndTopics>>
}