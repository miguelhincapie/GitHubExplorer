package com.mac.githubexplorer.data.repositories.repo.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RepoAndTopics(
    @Embedded
    val repoEntity: RepoEntity,
    @Relation(
        entity = TopicEntity::class,
        parentColumn = "repoId",
        entityColumn = "topicId",
        associateBy = Junction(
            value = RepoAndTopicCrossRef::class,
            parentColumn = "repoId",
            entityColumn = "topicId",
        )
    )
    val topics: List<TopicEntity>
)

//The opposite way TopicAndRepos, is not needed at all in this example