package com.mac.githubexplorer.data.repositories.repo.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * https://developer.android.com/training/data-storage/room/relationships#many-to-many
 */
@Entity(
    tableName = "repo_topic",
    primaryKeys = ["topicId", "repoId"],
    foreignKeys = [
        ForeignKey(
            entity = TopicEntity::class,
            parentColumns = ["topicId"],
            childColumns = ["topicId"]
        ),
        ForeignKey(
            entity = RepoEntity::class,
            parentColumns = ["repoId"],
            childColumns = ["repoId"]
        )
    ]
)
data class RepoAndTopicCrossRef(
    val repoId: Int,
    val topicId: Int,
)
