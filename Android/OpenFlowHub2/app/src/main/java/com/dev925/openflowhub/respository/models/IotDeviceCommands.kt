package com.dev925.openflowhub.respository.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by robertgross on 5/14/18.
 */

@Entity(tableName = "iot_device_commands")

data class IotDeviceCommands (
        @PrimaryKey(autoGenerate = true)
        var uid: String = UUID.randomUUID().toString()
)