package com.mac.githubexplorer.data.repositories.commons.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mac.githubexplorer.data.repositories.repo.local.datasource.dao.LicenseDao
import com.mac.githubexplorer.data.repositories.repo.local.datasource.dao.RepoDao
import com.mac.githubexplorer.data.repositories.repo.local.entity.LicenseEntity
import com.mac.githubexplorer.data.repositories.repo.local.entity.RepoAndTopicCrossRef
import com.mac.githubexplorer.data.repositories.repo.local.entity.RepoEntity
import com.mac.githubexplorer.data.repositories.repo.local.entity.TopicEntity
import com.mac.githubexplorer.data.repositories.user.local.datasource.dao.UserDao
import com.mac.githubexplorer.data.repositories.user.local.entity.UserEntity

@TypeConverters(value = [RoomConverters::class])
@Database(
    entities = [
        UserEntity::class,
        RepoEntity::class,
        TopicEntity::class,
        RepoAndTopicCrossRef::class,
        LicenseEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GitHubDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun repoDao(): RepoDao
    abstract fun licenseDao(): LicenseDao
}