package com.example.taskmanagingapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase: RoomDatabase(){
    companion object {
        private var taskDataBase: TaskDatabase? = null

        @Synchronized
        fun getDataBase(context: Context? = null): TaskDatabase {
            if (taskDataBase == null && context != null) {
                taskDataBase = Room.databaseBuilder(context, TaskDatabase::class.java, "tasks.db").build()
            }
            return taskDataBase!!
        }

        fun initDatabase(context: Context? = null) {
            getDataBase(context = context)
        }
    }

    abstract fun taskDao(): TaskDatabaseDao
}