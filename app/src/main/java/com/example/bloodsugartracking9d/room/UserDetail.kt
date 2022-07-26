package com.example.bloodsugartracking9d.room

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "note_table")
data class UserDetail(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "measurement_time")
    val measurement_time: String,

    @ColumnInfo(name = "unit")
    val unit: String,

    @ColumnInfo(name = "notes")
    val notes: String,

    @ColumnInfo(name = "medicines")
    val medicines: Boolean


)