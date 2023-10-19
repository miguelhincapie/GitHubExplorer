package com.mac.githubexplorer.data.repositories.repo.local.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import com.mac.githubexplorer.data.repositories.commons.local.BaseDao
import com.mac.githubexplorer.data.repositories.repo.local.entity.LicenseEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LicenseDao : BaseDao<LicenseEntity> {
    @Query("SELECT * FROM license")
    abstract fun getAll(): Flow<List<LicenseEntity>>

    @Query("SELECT * FROM license WHERE id =:licenseKey")
    abstract fun getByKey(licenseKey: String): Flow<LicenseEntity?>

    @Query("SELECT * FROM license WHERE id =:licenseKey")
    abstract suspend fun loadByKey(licenseKey: String): LicenseEntity?

    @Query("SELECT * FROM license WHERE name LIKE :first LIMIT 1")
    abstract fun findByName(first: String): Flow<LicenseEntity?>
}