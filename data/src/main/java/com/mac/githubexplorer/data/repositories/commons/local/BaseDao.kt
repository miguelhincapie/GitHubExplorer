package com.mac.githubexplorer.data.repositories.commons.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<T>)

    @Update
    suspend fun update(user: T)

    @Update
    suspend fun update(user: List<T>)

    @Delete
    suspend fun delete(user: T)

    @Delete
    suspend fun delete(users: List<T>)
}