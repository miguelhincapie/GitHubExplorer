package com.mac.githubexplorer.data.repositories.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Database DTO
@Entity(tableName = "Repo")
data class RepoDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "html_url")
    val htmlUrl: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "language")
    val language: String,
    @ColumnInfo(name = "stargazers_count")
    val stargazersCount: Int
)