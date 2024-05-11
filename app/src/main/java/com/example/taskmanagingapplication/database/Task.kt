package com.example.taskmanagingapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
class Task {
    @PrimaryKey
    var taskId: String = ""
    @ColumnInfo(name = "task_title")
    var title: String? = null
    @ColumnInfo(name = "task_description")
    var description: String? = null
    @ColumnInfo(name = "task_type_idea")
    var idea: Boolean? = false
    @ColumnInfo(name = "task_type_todo")
    var todo: Boolean? = false
    @ColumnInfo(name = "task_type_important")
    var important: Boolean? = false

}