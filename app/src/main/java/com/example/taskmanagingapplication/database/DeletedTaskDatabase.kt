package com.example.taskmanagingapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version =1)
abstract class DeletedTaskDatabase :RoomDatabase(){
    companion object {
        private var taskDatabase: DeletedTaskDatabase? = null

        @Synchronized
        fun getDatabase(context: Context? = null): DeletedTaskDatabase {
            if (taskDatabase == null && context != null) {
                taskDatabase = Room.databaseBuilder(context, DeletedTaskDatabase::class.java, "deleted_tasks.db").build()
            }
            return taskDatabase!!
        }

        fun initDatabase(context: Context? = null) {
            getDatabase(context = context)
        }
    }
    abstract fun taskDao(): TaskDatabaseDao
}