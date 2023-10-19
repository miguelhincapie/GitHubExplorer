package com.mac.githubexplorer.data.repositories.repo.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topic")
data class TopicEntity(
    @PrimaryKey(true)
    @ColumnInfo("topicId")
    val id: Int,
    @ColumnInfo("name")
    val name: String?
)