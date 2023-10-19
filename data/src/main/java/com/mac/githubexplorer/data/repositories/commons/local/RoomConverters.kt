package com.mac.githubexplorer.data.repositories.commons.local

import androidx.room.TypeConverter
import java.util.Date

class RoomConverters {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(date: Long): Date {
        return Date(date)
    }
}