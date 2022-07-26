package com.example.bloodsugartracking9d.room

import android.content.Context
import androidx.annotation.Keep
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Keep
@Database(entities = [UserDetail::class], version = 1, exportSchema = false)
abstract class UserDatabase() : RoomDatabase() {



    abstract fun getdao(): UserDao

    companion object {

        fun getDatabase(context: Context): UserDatabase {
            return Room.databaseBuilder(
                context.applicationContext, UserDatabase::class.java, DB_NAME).build()

        }

        const val DB_NAME = "note_database.db"
    }

}