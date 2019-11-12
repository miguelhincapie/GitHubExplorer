package com.mac.githubexplorer.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Database DTO
@Entity(tableName = "Feed")
data class FeedDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "first_name")
    val name: String,
    @ColumnInfo(name = "last_name")
    val htmlUrl: String,
    @ColumnInfo(name = "post_body")
    val description: String,
    @ColumnInfo(name = "unix_timestamp")
    val language: String,
    @ColumnInfo(name = "image")
    val stargazersCount: String
)