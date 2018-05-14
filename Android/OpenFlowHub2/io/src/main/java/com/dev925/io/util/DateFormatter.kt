package com.dev925.io.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {
    companion object {
        val dateFormat: DateFormat by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSS", Locale.US)
        }

    }
}
