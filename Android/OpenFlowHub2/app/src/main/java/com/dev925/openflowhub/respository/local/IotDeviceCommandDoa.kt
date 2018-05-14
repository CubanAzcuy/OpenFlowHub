package com.dev925.openflowhub.respository.local

import android.arch.persistence.room.*
import com.dev925.openflowhub.respository.models.IotDevice

@Dao
interface IotDeviceCommandDoa {

        /**
         * Select all tasks from the tasks table.
         *
         * @return all tasks.
         */
        @Query("SELECT * FROM Tasks") fun get(): List<IotDevice>

        /**
         * Select a task by id.
         *
         * @param id the task id.
         * @return the task with id.
         */
        @Query("SELECT * FROM Tasks WHERE entryid = :id") fun getById(id: String): IotDevice?

        /**
         * Insert a task in the database. If the task already exists, replace it.
         *
         * @param task the task to be inserted.
         */
        @Insert(onConflict = OnConflictStrategy.REPLACE) fun insert(task: IotDevice)

        /**
         * Update a task.
         *
         * @param task task to be updated
         * @return the number of tasks updated. This should always be 1.
         */
        @Update
        fun update(task: IotDevice): Int

        /**
         * Update the complete status of a task
         *
         * @param id    id of the task
         * @param completed status to be updated
         */
        @Query("UPDATE tasks SET completed = :completed WHERE entryid = :id")
        fun updateCompleted(id: String, completed: Boolean)

        /**
         * Delete a task by id.
         *
         * @return the number of tasks deleted. This should always be 1.
         */
        @Query("DELETE FROM Tasks WHERE entryid = :id") fun deleteById(id: String): Int

        /**
         * Delete all tasks.
         */
        @Query("DELETE FROM Tasks") fun delete()

        /**
         * Delete all completed tasks from the table.
         *
         * @return the number of tasks deleted.
         */
        @Query("DELETE FROM Tasks WHERE completed = 1") fun deleteCompleted(): Int
    }