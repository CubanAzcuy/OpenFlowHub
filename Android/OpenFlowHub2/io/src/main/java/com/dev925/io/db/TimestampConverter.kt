package com.dev925.io.db

import android.arch.persistence.room.TypeConverter
import com.dev925.io.util.DateFormatter
import java.util.*

object TimestampConverter {

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): Date? {
        return try {
            DateFormatter.dateFormat.parse(value)
        } catch (e: Exception) {
            null
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: Date?): String? {
        return try {
            DateFormatter.dateFormat.format(date)
        } catch (e: Exception) {
            null
        }
    }
}