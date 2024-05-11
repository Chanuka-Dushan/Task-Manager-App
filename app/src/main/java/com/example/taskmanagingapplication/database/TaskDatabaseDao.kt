package com.example.taskmanagingapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDatabaseDao {
    @Insert(onConflict = REPLACE)
    suspend fun save(task: Task)

    @Update
    suspend fun update(task: Task)
    @Query("DELETE FROM task_table")
    suspend fun clear()
    @Query("DELETE from task_table where taskId = :id")
    suspend fun deleteById(id: String)
@Query("SELECT * FROM task_table ORDER BY taskId ASC")
    fun getAllTasks(): LiveData<List<Task>>
    @Query("SELECT * FROM task_table ORDER BY taskId ASC")
    fun getAllTasksByIdOld(): LiveData<List<Task>>
    @Query("SELECT * FROM task_table ORDER BY task_title ASC")
    fun getAllTasksByTitle(): LiveData<List<Task>>
    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAllTasksByIdNew(): LiveData<List<Task>>
    @Query("SELECT * from task_table WHERE taskId = :key")
    fun getTaskWithId(key: String): Task

}