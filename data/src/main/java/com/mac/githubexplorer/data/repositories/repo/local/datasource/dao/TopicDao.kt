package com.mac.githubexplorer.data.repositories.repo.local.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import com.mac.githubexplorer.data.repositories.commons.local.BaseDao
import com.mac.githubexplorer.data.repositories.repo.local.entity.TopicEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TopicDao : BaseDao<TopicEntity> {
    @Query("SELECT * FROM topic")
    abstract fun getAll(): Flow<List<TopicEntity>>

    @Query("SELECT * FROM topic WHERE topicId =:topicName")
    abstract fun getByName(topicName: String): Flow<TopicEntity?>

    @Query("SELECT * FROM topic WHERE topicId =:topicName")
    abstract suspend fun loadByName(topicName: String): TopicEntity?

    @Query("SELECT * FROM topic WHERE name LIKE :topicName LIMIT 1")
    abstract fun findByName(topicName: String): Flow<TopicEntity?>
}