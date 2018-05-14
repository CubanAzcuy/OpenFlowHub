package com.dev925.openflowhub.respository

import java.util.concurrent.atomic.AtomicBoolean

class IotRepository(
        val iotRemoteDataSource: IotDataSource,
        val iotLocalDataSource: IotDataSource) : IotDataSource {

        companion object {
            lateinit var instance: IotDataSource
            private val initialised = AtomicBoolean(false)

            private fun getInstance(iotRemoteDataSource: IotDataSource, iotLocalDataSource: IotRepository) {
                synchronized(this) {
                    if (initialised.compareAndSet(false, true)) {
                        instance = IotRepository(iotRemoteDataSource, iotLocalDataSource)
                    } else {
                        instance
                    }
                }
            }

//            fun provideRepository(context: Context): IotRepository {
//                val database = ToDoDatabase.getInstance(context)
//                return getInstance(FakeTasksRemoteDataSource,
//                        TasksLocalDataSource.getInstance(AppExecutors(), database.taskDao()))
//            }
        }
}
