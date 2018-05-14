package com.dev925.openflowhub.respository.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.dev925.io.db.TimestampConverter
import com.dev925.openflowhub.respository.models.IotDeviceCommands

/**
 * Created by robertgross on 5/14/18.
 */

@Database(entities = arrayOf(IotDeviceDoa::class, IotDeviceCommands::class), version = 1)
@TypeConverters(TimestampConverter::class)
abstract class DevicesDatabase : RoomDatabase() {
    abstract fun iotDeviceDoa(): IotDeviceDoa
    abstract fun iotDeviceCommandDoa(): IotDeviceCommandDoa
}
