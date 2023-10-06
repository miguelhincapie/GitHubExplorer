package com.mac.githubexplorer.data.repositories.repo.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mac.githubexplorer.data.repositories.repo.remote.dto.LicenseDTO

// Database DTO
@Entity(tableName = "Repo")
data class RepoDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
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
    @ColumnInfo("license")
    val license: LicenseDTO?,
    @ColumnInfo("topics")
    val topics: List<String>?,
    @ColumnInfo("forks")
    val forks: Int?,
    @ColumnInfo("owner_login")
    val ownerLogin: String?
)