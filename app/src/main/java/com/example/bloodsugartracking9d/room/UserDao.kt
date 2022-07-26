package com.example.bloodsugartracking9d.room

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Keep
@Dao
interface UserDao {

    @Insert
     fun insert(userDatabase: UserDetail)


    @Delete
     fun delete(userDatabase: UserDetail)

    @Query("SELECT * FROM note_table")
     fun getuserdatalist(): LiveData<List<UserDetail>>


}