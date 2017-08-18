package org.androidsummit.notepad.data

import android.arch.persistence.room.TypeConverter

import org.threeten.bp.Instant

object TypeConverters {

    @JvmStatic
    @TypeConverter
    fun fromLong(timestamp: Long): Instant {
        return Instant.ofEpochMilli(timestamp)
    }

    @JvmStatic
    @TypeConverter
    fun fromInstant(date: Instant): Long {
        return date.toEpochMilli()
    }
}
