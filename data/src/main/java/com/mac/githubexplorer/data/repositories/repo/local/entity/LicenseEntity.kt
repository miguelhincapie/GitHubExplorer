package com.mac.githubexplorer.data.repositories.repo.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "license")
data class LicenseEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val key: String,
    @ColumnInfo("name")
    val name: String?,
    @ColumnInfo("spdx_id")
    val spdxId: String?,
    @ColumnInfo("url")
    val url: String?
)