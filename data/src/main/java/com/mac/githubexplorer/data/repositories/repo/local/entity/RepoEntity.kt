package com.mac.githubexplorer.data.repositories.repo.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo")
data class RepoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "repoId")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "full_name")
    val fullName: String,
    @ColumnInfo("private")
    val private: Boolean?,
    @ColumnInfo(name = "html_url")
    val htmlUrl: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo("url")
    val url: String?,
    @ColumnInfo(name = "language")
    val language: String,
    @ColumnInfo(name = "stargazers_count")
    val stargazersCount: Int,
    @ColumnInfo("homepage")
    val homepage: String?,
    @Embedded(prefix = "license")
    val license: LicenseEntity?,
    @ColumnInfo("forks")
    val forks: Int?,
    @ColumnInfo("owner_login")
    val ownerLogin: String?
)