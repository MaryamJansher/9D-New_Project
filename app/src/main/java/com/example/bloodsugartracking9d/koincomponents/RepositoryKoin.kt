package com.example.bloodsugartracking9d.koincomponents

import androidx.lifecycle.MutableLiveData
import com.example.bloodsugartracking9d.prefrences.TinyDb
import com.example.bloodsugartracking9d.room.UserDao
import com.example.bloodsugartracking9d.room.UserDetail

class RepositoryKoin(val userDao: UserDao, val tinyDb: TinyDb) {

    var unit_selected = MutableLiveData<String>()

    fun getalldata() = userDao.getuserdatalist()
    fun insert(userDetail: UserDetail) = userDao.insert(userDetail)
    fun delete(userDetail: UserDetail) = userDao.delete(userDetail)
    fun save_time(time: String) = tinyDb.putString(com.example.bloodsugartracking9d.save_time, time)
    fun save_date(date: String) = tinyDb.putString(com.example.bloodsugartracking9d.save_date, date)

    fun set_unit_selected(unit: String): MutableLiveData<String> {
        unit_selected.value = unit

        return unit_selected

    }

    var get_unit_selected = unit_selected



}